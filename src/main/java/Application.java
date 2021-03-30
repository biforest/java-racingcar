import domain.CarFactory;
import domain.Cars;
import domain.MoveStrategy;
import domain.RacingCarGame;
import domain.RandomMoveStrategy;
import ui.Printer;
import ui.Receiver;

public class Application {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Printer printer = new Printer();

        CarFactory carFactory = new CarFactory();
        RacingCarGame racingCarGame = new RacingCarGame(carFactory.createCars(receiver.receiveCarNames()));
        int round = receiver.receiveRound();

        System.out.println(Printer.RESULT_START_MESSAGE);
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        for (int r = 0; r < round; r++) {
            racingCarGame.proceedOneRound(moveStrategy);
            printer.printCurrentPositions(racingCarGame.getCars());
        }

        Cars winners = racingCarGame.chooseWinners();
        printer.printWinners(winners);
    }
}
