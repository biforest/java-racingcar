package domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ui.Printer;
import utils.RandomUtils;

public class RacingCarGame {
    private final List<Car> cars;
    private final int round;
    private List<Car> winners;

    public RacingCarGame(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
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

    private void proceedOneRound() {
        for (int idx = 0; idx < cars.size(); idx++) {
            movePosition(idx);
        }
    }

    public void proceedRounds() {
        for (int r = 0; r < round; r++) {
            proceedOneRound();
            Printer.printCurrentPositions(cars);
        }
    }

    public List<Car> chooseWinners() {
        int maxPosition = cars.stream()
            .max((Comparator.comparingInt(Car::getPosition)))
            .orElseThrow(IllegalArgumentException::new)
            .getPosition();

        return winners = cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .collect(Collectors.toList());
    }
}
