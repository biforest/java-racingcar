package domain;

import io.Message;
import io.Printer;
import io.Receiver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamePlayer {
    private static final int WINNER_CONDITION = 4;

    private final Printer printer;
    private final Receiver receiver;
    private final Generator generator;

    public GamePlayer() {
        this.printer = new Printer();
        this.receiver = new Receiver();
        this.generator = new Generator();
    }

    void judgeAndMove(Car car, int randomNumber) {
        if (randomNumber >= WINNER_CONDITION) {
            car.moveForward();
        }
    }

    List<Car> inputNames() {
        String messageCode = Message.GeneralMessages.INPUT_NAMEOFCAR.getMessage();
        printer.printMessages(messageCode);
        List<String> names = new ArrayList<>(Arrays.asList(receiver.receiveName()));

        return makeCarList(names);
    }

    int inputNumber() {
        String messageCode = Message.GeneralMessages.INPUT_COUNT.getMessage();
        printer.printMessages(messageCode);

        return receiver.receiveNumber();
    }

    List<Car> makeCarList(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < names.size(); i++)
            cars.add(new Car(names.get(i)));

        return cars;
    }

    void launchAllRound(ArrayList<Car> cars, int countRound) {
        String messageCode = Message.GeneralMessages.DEFAULT_SPACE.getMessage();

        for (int i = 0; i < countRound; i++) {
            for (Car car : cars) {
                judgeAndMove(car, generator.generateRandomNumber());
                printer.printProgress(car.getName(), car.getProgressWithSymbol());
            }
            printer.printMessages(messageCode);
        }
    }

    public void run() {
        String messageCode = Message.GeneralMessages.OPERATION_RESULT.getMessage();
        ArrayList<Car> cars = inputNames();
        int countRound = inputNumber();

        printer.printMessages(messageCode);
        launchAllRound(cars, countRound);

        ArrayList<Car> winner = Winner.checkWhoIsWinner(cars);
        printer.printWinner(Winner.makeWinnerToString(winner));
    }
}
