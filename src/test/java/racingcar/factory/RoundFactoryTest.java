package racingcar.factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.round.Round;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class RoundFactoryTest {

    @Test
    void createRounds() {
        //given
        int expected = 5;

        //when
        List<Round> rounds = RoundFactory.createRounds(5);

        //then
        assertThat(rounds.size()).isEqualTo(expected);
        rounds.forEach(round -> assertThat(round).isNotNull());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    void 라운드_수가_0이하인_경우_예외(int numberOfRounds) {
        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> RoundFactory.createRounds(numberOfRounds))
                .withMessage("라운드 횟수는 1이상이어야 합니다.");
    }
}