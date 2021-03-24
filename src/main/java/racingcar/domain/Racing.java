package racingcar.domain;

import racingcar.domain.car.Cars;
import racingcar.domain.round.Rounds;
import racingcar.ui.Printer;

import java.util.List;

public class Racing {
    private final Cars cars;
    private final Rounds rounds;

    public Racing(Cars cars, Rounds rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public Winner winners(Printer printer) {
        rounds.process(cars, printer);
        List<String> maxPositionCarNames = cars.getMaxPositionCarNames();
        return new Winner(maxPositionCarNames);
    }
}
