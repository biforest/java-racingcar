package racingcar.domain.round;

import racingcar.domain.car.Cars;
import racingcar.strategy.MoveStrategy;

public class Round {

    public void process(Cars cars, MoveStrategy moveStrategy) {
        cars.moveEachCar(moveStrategy);
    }
}
