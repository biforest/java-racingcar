package domain;

import io.Printer;
import io.Receiver;

import java.util.ArrayList;
import java.util.List;

public class GamePlayer {
    private Printer printer;
    private Receiver receiver;
    private Generator generator;

    public GamePlayer() {
        this.printer = new Printer();
        this.receiver = new Receiver();
        this.generator = new Generator();
    }

    private final int WINNER_CONDITION = 4;

    public void judgeToMove(Car car, int randomNumber) {
        if (randomNumber >= WINNER_CONDITION)
            car.moveForward();
    }

    public Car[] makeArrayAfterGettingName() {
        printer.printGeneralMessage("INPUT_NAMEOFCAR");
        String[] listOfName = receiver.receiveName();

        Car[] cars = new Car[listOfName.length];
        for (int i = 0; i < listOfName.length; i++)
            cars[i] = new Car(listOfName[i]);

        return cars;
    }

    public int makeCountAfterGettingNumber() {
        printer.printGeneralMessage("INPUT_COUNT");
        return receiver.receiveNumber();
    }

    public void launchAllRound(Car[] cars, int countRound) {
        for (int i = 0; i < countRound; i++) {
            for (Car j : cars) {
                judgeToMove(j, generator.generateRandomNumber());
                printer.printProgressWithSymbol(j.getName(), j.getPosition());
            }
            printer.printGeneralMessage("DEFAULT_SPACE");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace(); 
            }
        }
    }

    public List<Car> checkWhoIsWinner(Car[] cars) {
        List<Car> result = new ArrayList<>();
        int maxNumber = 0;

        for (Car i : cars) {
            if(i.getPosition() == maxNumber){
                result.add(i);
                continue;
            }
            if (i.getPosition() > maxNumber) {
                maxNumber = i.getPosition();
                result.clear();
                result.add(i);
            }
        }

        return result;
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
