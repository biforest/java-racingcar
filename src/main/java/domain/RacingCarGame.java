package domain;

import java.util.List;

import utils.RandomUtils;

public class RacingCarGame {
    private final List<Car> cars;
    private final int round;
    private final int numberOfCars;

    public RacingCarGame(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
        numberOfCars = cars.size();
    }

    private int makeRandomValue() {
        return RandomUtils.nextInt(0, 9);
    }

    private void movePosition(int idx) {
        int randomValue = makeRandomValue();
        if (randomValue >= 4) {
            cars.get(idx).moveForward();
        }
    }

    private void playRound() {
        for (int idx = 0; idx < numberOfCars; idx++) {
            movePosition(idx);
        }
    }

    private void printResultPerRound() {
        for (int idx = 0; idx < numberOfCars; idx++) {
            System.out.print(cars.get(idx).getName() + " : ");
            printPositionOfCar(idx);
        }
        System.out.println();
    }

    private void printPositionOfCar(int idx) {
        int position = cars.get(idx).getPosition();
        while (position-- > 0) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void playGame() {
        System.out.println("\n실행 결과");

        for (int r = 0; r < round; r++) {
            playRound();
            printResultPerRound();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
