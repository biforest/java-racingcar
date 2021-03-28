package domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String COMMA = ", ";

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(MoveStrategy moveStrategy) {
        for (int i = 0; i < cars.size(); i++) {
            movePosition(i, moveStrategy);
        }
    }

    private void movePosition(int idx, MoveStrategy moveStrategy) {
        cars.get(idx).moveForward(moveStrategy);
    }

    public int getMaxPosition() {
        return cars.stream()
            .max((Comparator.comparingInt(Car::getPosition)))
            .orElseThrow(IllegalArgumentException::new)
            .getPosition();
    }

    public List<Car> findWinners(int maxPosition) {
        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .collect(Collectors.toList());
    }

    public String toStringCurrentPositions() {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append(cars.stream()
            .map(Car::toString)
            .collect(Collectors.joining()))
            .toString();
    }

    public String toStringWinners() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(cars.get(0).getName());
        if (cars.size() == 1) {
            return stringBuilder.toString();
        }

        for (int i = 1; i < cars.size(); i++) {
            stringBuilder.append(COMMA + cars.get(i).getName());
        }
        return stringBuilder.toString();
    }

    public List<Car> getCars() {
        return cars;
    }
}
