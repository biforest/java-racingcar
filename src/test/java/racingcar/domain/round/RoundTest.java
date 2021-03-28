package racingcar.domain.round;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RoundTest {

    @Test
    void 정상적인_입력() {
        //given
        int expected = 5;

        //when
        Round round = new Round(expected);

        //then
        assertThat(round.getNumberOfRounds()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    void 라운드_수가_0이하인_경우_예외(int numberOfRounds) {
        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Round(numberOfRounds))
                .withMessage("라운드 횟수는 1이상이어야 합니다.");
    }
}