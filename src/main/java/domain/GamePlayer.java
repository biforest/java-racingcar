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
        if (randomNumber >= WINNER_CONDITION)
            car.moveForward();
    }

    Car[] makeArrayAfterGettingName() {
        String messageCode = Message.GeneralMessages.INPUT_NAMEOFCAR.getMessage();
        printer.printMessages(messageCode);
        ArrayList<String> names = new ArrayList<>(Arrays.asList(receiver.receiveName()));

        Car[] cars = new Car[names.size()];
        for (int i = 0; i < names.size(); i++)
            cars[i] = new Car(names.get(i));

        return cars;
    }

    int makeCountAfterGettingNumber() {
        String messageCode = Message.GeneralMessages.INPUT_COUNT.getMessage();
        printer.printMessages(messageCode);
        return receiver.receiveNumber();
    }

    void launchAllRound(Car[] cars, int countRound) {
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
        Car[] cars = makeArrayAfterGettingName();
        int countRound = makeCountAfterGettingNumber();

        printer.printMessages(messageCode);
        launchAllRound(cars, countRound);

        List<Car> winner = Winner.checkWhoIsWinner(cars);
        printer.printWinner(Winner.makeWinnerToString(winner));
    }
}
