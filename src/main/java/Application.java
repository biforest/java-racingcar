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
        CarFactory carFactory = new CarFactory();
        RacingCarGame racingCarGame = new RacingCarGame(carFactory.createCars(receiver.getCarNames()));

        System.out.println(Printer.RESULT_START_MESSAGE);
        int round = receiver.getRound();
        for (int r = 0; r < round; r++) {
            racingCarGame.proceedOneRound();
            printer.printCurrentPositions(racingCarGame.getCars());
        }

        List<Car> winners = racingCarGame.chooseWinners();
        printer.printWinners(winners);
    }
}
