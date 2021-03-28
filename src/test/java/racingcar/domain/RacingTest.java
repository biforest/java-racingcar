package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.round.Round;
import racingcar.strategy.ThresholdStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @DisplayName("항상 움직이는 이동 전략으로 레이싱 시작")
    @Test
    void start() {
        //given
        Cars cars = new Cars(Arrays.asList(new Car("a"), new Car("b"), new Car("c")));
        Round round = new Round(2);
        Racing racing = new Racing(cars, round);

        //when
        List<Cars> results = racing.start(new ThresholdStrategy(4, 4));

        //then
        int expected = 1;
        for (Cars result : results) {
            int finalExpected = expected;
            result.getCollection()
                    .forEach(car -> assertThat(car.getPosition().getPosition()).isEqualTo(finalExpected));

            expected++;
        }
    }

    @DisplayName("항상 움직이는 이동 전략으로 레이싱 시작시 모두 우승")
    @Test
    void winners() {
        //given
        Cars cars = new Cars(Arrays.asList(new Car("a"), new Car("b"), new Car("c")));
        Round round = new Round(2);
        Racing racing = new Racing(cars, round);

        //when
        racing.start(new ThresholdStrategy(4, 4));
        Winner winners = racing.winners();

        //then
        assertThat(winners.toString()).isEqualTo("a, b, c");
    }
}
