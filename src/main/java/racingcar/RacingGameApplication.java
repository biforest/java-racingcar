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
import racingcar.ui.receiver.ConsoleReceiver;
import racingcar.ui.receiver.InputExceptionHandler;
import racingcar.ui.receiver.InputValidator;
import racingcar.ui.receiver.Receiver;

import java.util.List;


public class RacingGameApplication {

    private final Printer printer;
    private final Receiver receiver;

    public RacingGameApplication(Printer printer, Receiver receiver) {
        this.printer = printer;
        this.receiver = receiver;
    }

    public void run() {
        printer.requestCarName();
        List<Car> cars = createCars();
        Cars wrappedCars = new Cars(cars);

        printer.requestNumberOfRounds();
        List<Round> rounds = createRounds();
        Rounds wrappedRounds = new Rounds(rounds);

        Racing racing = new Racing(wrappedCars, wrappedRounds);
        Winner winners = racing.winners(printer);
        printer.printWinner(winners);
    }

    private List<Car> createCars() {
        try {
            return CarFactory.createCars(receiver.receiveCarNames());
        } catch (IllegalArgumentException e) {
            printer.printExceptionMessage(e);
            return CarFactory.createCars(receiver.receiveCarNames());
        }
    }

    private List<Round> createRounds() {
        try {
            return RoundFactory.createRounds(receiver.receiveNumberOfRounds());
        } catch (IllegalArgumentException e) {
            printer.printExceptionMessage(e);
            return RoundFactory.createRounds(receiver.receiveNumberOfRounds());
        }
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        Receiver receiver = new InputExceptionHandler(new InputValidator(new ConsoleReceiver(System.in)), printer);
        RacingGameApplication app = new RacingGameApplication(printer, receiver);
        app.run();
    }
}

