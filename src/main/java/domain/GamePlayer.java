package domain;

import io.Printer;
import io.Receiver;

import java.util.ArrayList;
import java.util.List;

public class GamePlayer {
    private static final int WINNER_CONDITION = 4;

    private final Printer printer;
    private final Receiver receiver;
    private final Generator generator;

    public GamePlayer() {
        this.printer = new Printer();
        this.receiver = new Receiver();
        this.generator = new Generator(10);
    }

    void judgeAndMove(Car car, int randomNumber) {
        if (randomNumber >= WINNER_CONDITION)
            car.moveForward();
    }

    Car[] makeArrayAfterGettingName() {
        printer.printGeneralMessage("INPUT_NAMEOFCAR");
        String[] listOfName = receiver.receiveName();

        Car[] cars = new Car[listOfName.length];
        for (int i = 0; i < listOfName.length; i++)
            cars[i] = new Car(listOfName[i]);

        return cars;
    }

    int makeCountAfterGettingNumber() {
        printer.printGeneralMessage("INPUT_COUNT");
        return receiver.receiveNumber();
    }

    void launchAllRound(Car[] cars, int countRound) {
        for (int i = 0; i < countRound; i++) {
            for (Car car : cars) {
                judgeAndMove(car, generator.generateRandomNumber());
                printer.printProgressWithSymbol(car.getName(), car.getPosition());
            }
            printer.printGeneralMessage("DEFAULT_SPACE");
        }
    }

    List<Car> checkWhoIsWinner(Car[] cars) {
        List<Car> winner = new ArrayList<>();
        int maxNumber = 0;

        for (Car car : cars) {
            if(car.getPosition() == maxNumber){
                winner.add(car);
                continue;
            }
            if (car.getPosition() > maxNumber) {
                maxNumber = car.getPosition();
                winner.clear();
                winner.add(car);
            }
        }

        return winner;
    }

    public void run() {
        Car[] cars = makeArrayAfterGettingName();
        int countRound = makeCountAfterGettingNumber();

        printer.printGeneralMessage("OPERATION_RESULT");
        launchAllRound(cars, countRound);

        List<Car> winner = checkWhoIsWinner(cars);
        printer.printWinner(printer.makeWinnerToString(winner));
    }
}
