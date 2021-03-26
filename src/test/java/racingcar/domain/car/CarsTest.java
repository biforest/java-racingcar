package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.ThresholdStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {

    @DisplayName("가장 멀리 간 Car 객체의 이름들을 반환")
    @Test
    void getMaxPositionCarNames() {
        //given
        MoveStrategy strategy = new ThresholdStrategy(4, 4);
        Car a = new Car("a").move(strategy);
        Car b = new Car("b").move(strategy).move(strategy);
        Car c = new Car("c").move(strategy).move(strategy);

        Cars cars = new Cars(Arrays.asList(a, b, c));

        //when
        List<String> maxPositionCarNames = cars.getMaxPositionCarNames();

        //then
        assertThat(maxPositionCarNames).isEqualTo(Arrays.asList("b", "c"));
    }

    @DisplayName("항상 움직이는 이동 전략과 항상 움직이지 않는 이동 전략을 한번씩 이용하여 Car 객체들을 이동")
    @Test
    void moveEachCar() {
        //given
        int expected = 1;
        MoveStrategy forwardStrategy = new ThresholdStrategy(4, 4);
        MoveStrategy stopStrategy = new ThresholdStrategy(10, 0);

        Cars cars = new Cars(Arrays.asList(new Car("a"), new Car("b"), new Car("c")));

        //when
        cars = cars.moveEachCar(forwardStrategy);
        cars = cars.moveEachCar(stopStrategy);

        //then
        Collection<Car> collection = cars.getCollection();
        for (Car car : collection) {
            assertThat(car.getPosition().getPosition()).isEqualTo(expected);
        }
    }

    @DisplayName("Cars 객체의 불변성")
    @Test
    void immutabilityTest() {
        //given
        Cars cars = new Cars(Arrays.asList(new Car("a"), new Car("b"), new Car("c")));

        //when
        Cars newCars = cars.moveEachCar(new ThresholdStrategy(10, 0));

        //then
        assertThat(cars).isNotEqualTo(newCars);
    }
}