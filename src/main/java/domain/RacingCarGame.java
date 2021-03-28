package domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final List<Car> cars;
    private List<Car> winners;

    public RacingCarGame(List<Car> cars) {
        this.cars = cars;
    }

    public void proceedOneRound(MoveStrategy moveStrategy) {
        for (int i = 0; i < cars.size(); i++) {
            movePosition(i, moveStrategy);
        }
    }

    private void movePosition(int idx, MoveStrategy moveStrategy) {
        cars.get(idx).moveForward(moveStrategy);
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
