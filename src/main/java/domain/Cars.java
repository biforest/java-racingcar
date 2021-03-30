package domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

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
            .filter(car -> car.isSameWithPosition(maxPosition))
            .collect(Collectors.toList());
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }
}
