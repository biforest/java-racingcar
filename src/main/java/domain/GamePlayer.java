package domain;

import io.Printer;
import io.Receiver;

import java.util.ArrayList;
import java.util.List;

public class GamePlayer {
    private final int WINNER_CONDITION = 4;
    private final Printer printer = new Printer();
    private final Receiver receiver = new Receiver();
    private final Generator generator= new Generator();
    private final CarManager carManager = new CarManager();

    public void judgeToMove(Car car, int randomNumber) {
        if (randomNumber >= WINNER_CONDITION)
            car.moveForward();
    }

    public int receiveRepeatCount() {
        printer.printGeneralMessage("INPUT_COUNT");
        return receiver.receiveNumber();
    }

    public void launchAllRound(Car[] cars, int countRound) {
        for (int i = 0; i < countRound; i++) {
            for (Car car : cars) {
                judgeToMove(car, generator.generateRandomNumber());
                printer.printProgressWithSymbol(car.getName(), car.getPosition());
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

        for (Car car : cars) {
            if(car.getPosition() == maxNumber){
                result.add(car);
                continue;
            }
            if (car.getPosition() > maxNumber) {
                maxNumber = car.getPosition();
                result.clear();
                result.add(car);
            }
        }

        return result;
    }

    public void run() {
        printer.printGeneralMessage("INPUT_NAMEOFCAR");
        Car[] cars = carManager.produceCar();
        int countRound = receiveRepeatCount();

        printer.printGeneralMessage("OPERATION_RESULT");
        launchAllRound(cars, countRound);

        List<Car> winner = checkWhoIsWinner(cars);
        printer.printWinner(printer.makeWinnerToString(winner));
    }
}
