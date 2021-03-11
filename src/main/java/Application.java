import java.util.List;

import domain.Car;
import domain.CarFactory;
import domain.RacingCarGame;
import ui.Input;
import ui.Printer;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        String[] carNames = input.getCarNames();
        int round = input.getRound();

        CarFactory factory = new CarFactory(carNames);
        List<Car> cars = factory.getCars();

        RacingCarGame game = new RacingCarGame(cars, round);
        game.playGame();
        List<Car> result = game.getCars();

        Printer printer = new Printer(result);
        printer.printWinners();
    }
}
