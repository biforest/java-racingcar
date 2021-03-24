package racingcar.domain.round;

import racingcar.domain.car.Cars;
import racingcar.strategy.MoreThanFourMoveStrategy;
import racingcar.ui.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rounds {
    private final List<Round> rounds;

    public Rounds(List<Round> rounds) {
        this.rounds = new ArrayList<>(rounds);
    }

    public void process(Cars cars, Printer printer) {
        printer.printResultHeader();
        rounds.forEach(round -> {
            round.process(cars, new MoreThanFourMoveStrategy(new Random()));
            printer.printCarState(cars);
        });
    }

}
