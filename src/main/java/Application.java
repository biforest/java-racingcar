import domain.CarFactory;
import domain.RacingCarGame;
import ui.Receiver;

public class Application {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        CarFactory carFactory = new CarFactory(receiver.getCarNames());
        RacingCarGame racingCarGame = new RacingCarGame(carFactory.getCars(), receiver.getRound());

        racingCarGame.proceedRounds();
        racingCarGame.printWinners();
    }
}
