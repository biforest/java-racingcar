package racingcar.ui.receiver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import racingcar.ui.Printer;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ReceiverTest {

    private final Printer printer = new Printer();

    @MethodSource(value = "validRoundProvider")
    @ParameterizedTest(name = "정상적인 라운드 입력 [{index}] : input = {0}, expected = {1}")
    void 라운드_입력(String input, int expected) {
        //given
        Receiver receiver = new InputExceptionHandler(
                                new InputValidator(
                                        new ConsoleReceiver(
                                                new ByteArrayInputStream(input.getBytes()
                                                )
                                        )
                                ), printer);

        //when then
        assertThat(receiver.receiveNumberOfRounds()).isEqualTo(expected);
    }

    private static Stream<Arguments> validRoundProvider() {
        return Stream.of(
                Arguments.of("22", 22),
                Arguments.of("1", 1),
                Arguments.of("1000", 1000)
        );
    }

    @DisplayName("라운드 입력으로 숫자가 아닌 경우")
    @Test
    void 라운드_입력으로_숫자가_아닌_경우() {
        //given
        String input = "a";
        Receiver receiver = new InputValidator(new ConsoleReceiver(new ByteArrayInputStream(input.getBytes())));

        //when then
        assertThatExceptionOfType(InputMismatchException.class)
                .isThrownBy(receiver::receiveNumberOfRounds);
    }

    @ValueSource(strings = {"0", "-1", "-20"})
    @ParameterizedTest(name = "라운드 입력으로 0이하 숫자인 경우 [{index}] : input = {0}")
    void 라운드_입력으로_0이하_숫자인_경우(String input) {
        //given
        Receiver receiver = new InputValidator(new ConsoleReceiver(new ByteArrayInputStream(input.getBytes())));

        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(receiver::receiveNumberOfRounds);
    }

    @MethodSource(value = "validAfterInvalidRoundProvider")
    @ParameterizedTest(name = "라운드 입력으로 비정상적인 입력 후에 정상적인 입력이 들어오는 경우 [{index}]" +
            " : input = {0}, expected = {1}")
    void 라운드_입력으로_비정상적인_입력이_들어오고_다음에_정상적인_입력이_들어오는_경우(String input, int expected) {
        //given
        Receiver receiver = new InputExceptionHandler(
                                new InputValidator(
                                        new ConsoleReceiver(
                                                new ByteArrayInputStream(input.getBytes()
                                                )
                                        )
                                ), printer);

        //when then
        assertThat(receiver.receiveNumberOfRounds()).isEqualTo(expected);
    }

    private static Stream<Arguments> validAfterInvalidRoundProvider() {
        return Stream.of(
                Arguments.of("s\n2", 2),
                Arguments.of("-1\n3", 3),
                Arguments.of("s\n-1\n4", 4)
        );
    }

    @MethodSource(value = {"validCarNamesProvider"})
    @ParameterizedTest(name = "정상적인 Car 객체 이름 입력 [{index}] : input = {0}, expected = {1}")
    void Car_객체_이름_정상적인_입력(String input, String expected) {
        //given
        Receiver receiver = new InputExceptionHandler(
                                new InputValidator(
                                        new ConsoleReceiver(
                                                new ByteArrayInputStream(input.getBytes()
                                                )
                                        )
                                ), printer);

        //when then
        assertThat(receiver.receiveCarNames()).isEqualTo(expected);
    }

    private static Stream<Arguments> validCarNamesProvider() {
        return Stream.of(
                Arguments.of("a,b,c\n", "a,b,c"),
                Arguments.of("ab ed,v\n", "ab ed,v"),
                Arguments.of("^f%c,_car_\n", "^f%c,_car_")
        );
    }

    @ValueSource(strings = {",,", ",a,", "A,,,b"})
    @ParameterizedTest(name = "비정상적인 Car 객체 이름 입력 [{index}] : input = {0}")
    void Car_객체_이름_비정상적인_입력(String input) {
        //given
        Receiver receiver = new InputValidator(new ConsoleReceiver(new ByteArrayInputStream(input.getBytes())));

        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(receiver::receiveCarNames)
                .withMessage("자동차 이름의 입력은 콤마로 구분하여 하나 이상 입력해주세요.");
    }

    @MethodSource(value = {"validAfterInvalidCarNamesProvider"})
    @ParameterizedTest(name = "비정상적인 입력 후에 정상적인 Car 객체 이름 입력 [{index}] : input = {0}, expected = {1}")
    void Car객체_입력으로_비정상적인_입력이_들어오고_다음에_정상적인_입력이_들어오는_경우(String input, String expected) {
        //given
        Receiver receiver = new InputExceptionHandler(
                new InputValidator(
                        new ConsoleReceiver(
                                new ByteArrayInputStream(input.getBytes()
                                )
                        )
                ), printer);

        //when then
        assertThat(receiver.receiveCarNames()).isEqualTo(expected);
    }

    private static Stream<Arguments> validAfterInvalidCarNamesProvider() {
        return Stream.of(
                Arguments.of(",,\na,b,c\n", "a,b,c"),
                Arguments.of(",a,\nab ed,v\n", "ab ed,v"),
                Arguments.of("A,,,b\n^f%c,_car_\n", "^f%c,_car_"),
                Arguments.of(",,\n,,b\ncar,caa,cab", "car,caa,cab")
        );
    }
}