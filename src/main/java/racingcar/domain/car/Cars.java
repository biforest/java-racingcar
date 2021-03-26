package racingcar.domain.car;

import racingcar.strategy.MoveStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static final String DUPLICATED_NAME_EXCEPTION_MESSAGE = "중복되는 이름의 차를 입력하실 수 없습니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
        validate();
    }

    private void validate() {
        if (cars.size() != new HashSet<>(cars).size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_EXCEPTION_MESSAGE);
        }
    }

    public List<String> getMaxPositionCarNames() {
        int maxPosition = cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow()
                .getPosition()
                .getPosition();

        return cars.stream()
                .filter(car -> car.isWinnerPosition(maxPosition))
                .map(car -> car.getName().getName())
                .collect(Collectors.toList());
    }

    public Cars moveEachCar(MoveStrategy moveStrategy) {
        List<Car> cars = new ArrayList<>();
        this.cars.forEach(car -> cars.add(car.move(moveStrategy)));
        return new Cars(cars);
    }

    public Collection<Car> getCollection() {
        return cars;
    }
}
