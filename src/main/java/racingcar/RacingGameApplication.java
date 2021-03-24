package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.round.Rounds;
import racingcar.domain.Winner;
import racingcar.domain.car.Cars;
import racingcar.ui.Printer;
import racingcar.ui.Receiver;


public class RacingGameApplication {

    private final Printer printer = new Printer();
    private final Receiver receiver = new Receiver();

    public void run() {
        Cars cars = new Cars(receiver.receiveCarNames(printer));
        Rounds rounds = new Rounds(receiver.receiveNumberOfRounds(printer));

        Racing racing = new Racing(cars, rounds);
        Winner winners = racing.winners(printer);
        printer.printWinner(winners);
    }

    public static void main(String[] args) {
        RacingGameApplication app = new RacingGameApplication();
        app.run();
    }
}

