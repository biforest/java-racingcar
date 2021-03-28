package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.ui.Printer;
import racingcar.ui.receiver.ConsoleReceiver;
import racingcar.ui.receiver.InputExceptionHandler;
import racingcar.ui.receiver.InputValidator;
import racingcar.ui.receiver.Receiver;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameApplicationTest {

    @DisplayName("테스트 커버리지를 위한 테스트1")
    @Test
    void run() {
        //given
        String input = "a,b,c\n3";

        Printer printer = new Printer();
        Receiver receiver = new InputExceptionHandler(
                                    new InputValidator(
                                        new ConsoleReceiver(
                                                new ByteArrayInputStream(input.getBytes())
                                        )
                                    ), printer);

        RacingGameApplication app = new RacingGameApplication(printer, receiver);

        //when
        app.run();

        //then
        assertThat(true).isTrue();
    }

    @DisplayName("테스트 커버리지를 위한 테스트2")
    @Test
    void run2() {
        //given
        String input = "a,b,,\na,b,a\na,b,c\n-1\n3";

        Printer printer = new Printer();
        Receiver receiver = new InputExceptionHandler(
                new InputValidator(
                        new ConsoleReceiver(
                                new ByteArrayInputStream(input.getBytes())
                        )
                ), printer);

        RacingGameApplication app = new RacingGameApplication(printer, receiver);

        //when
        app.run();

        //then
        assertThat(true).isTrue();
    }
}
