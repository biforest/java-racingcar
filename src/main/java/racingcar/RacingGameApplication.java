package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.car.Car;
import racingcar.domain.round.Round;
import racingcar.domain.round.Rounds;
import racingcar.domain.Winner;
import racingcar.domain.car.Cars;
import racingcar.factory.CarFactory;
import racingcar.factory.RoundFactory;
import racingcar.ui.Printer;
import racingcar.ui.Receiver;

import java.util.List;


public class RacingGameApplication {

    private final Printer printer = new Printer();
    private final Receiver receiver = new Receiver();

    public void run() {
        List<Car> cars = CarFactory.createCars(receiver.receiveCarNames(printer));
        Cars wrappedCars = new Cars(cars);

        List<Round> rounds = RoundFactory.createRounds(receiver.receiveNumberOfRounds(printer));
        Rounds wrappedRounds = new Rounds(rounds);

        Racing racing = new Racing(wrappedCars, wrappedRounds);
        Winner winners = racing.winners(printer);
        printer.printWinner(winners);
    }

    public static void main(String[] args) {
        RacingGameApplication app = new RacingGameApplication();
        app.run();
    }
}

