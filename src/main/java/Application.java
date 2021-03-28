import java.util.List;

import domain.Car;
import domain.CarFactory;
import domain.RacingCarGame;
import ui.Printer;
import ui.Receiver;

public class Application {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Printer printer = new Printer();
        CarFactory carFactory = new CarFactory(receiver.getCarNames());
        RacingCarGame racingCarGame = new RacingCarGame(carFactory.getCars(), receiver.getRound());

        System.out.println(Printer.RESULT_START_MESSAGE);

        racingCarGame.proceedRounds();
        List<Car> winners = racingCarGame.chooseWinners();
        printer.printWinners(winners);
    }
}
