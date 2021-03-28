package domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import utils.RandomUtils;

public class RacingCarGame {
    private static final int MIN_POWER = 4;

    private final List<Car> cars;
    private List<Car> winners;

    public RacingCarGame(List<Car> cars) {
        this.cars = cars;
    }

    public void proceedOneRound() {
        IntStream.range(0, cars.size()).forEach(this::movePosition);
    }

    private void movePosition(int idx) {
        int randomValue = makeRandomValue();
        if (randomValue >= MIN_POWER) {
            cars.get(idx).moveForward();
        }
    }

    private int makeRandomValue() {
        return RandomUtils.nextInt(0, 9);
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

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        return winners;
    }
}
