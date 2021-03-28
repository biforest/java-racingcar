package racingcar.domain;

import racingcar.domain.car.Cars;
import racingcar.domain.round.Round;
import racingcar.strategy.MoveStrategy;

import java.util.List;

public class Racing {
    private Cars cars;
    private final Round round;

    public Racing(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public List<Cars> start(MoveStrategy moveStrategy) {
        List<Cars> results = round.process(cars, moveStrategy);
        cars = results.get(results.size() - 1);
        return results;
    }

    public Winner winners() {
        return new Winner(cars.getMaxPositionCarNames());
    }
}
