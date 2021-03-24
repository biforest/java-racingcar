package racingcar.domain.car;

import racingcar.strategy.MoveStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static final String DUPLICATED_NAME_EXCEPTION_MESSAGE = "중복되는 이름의 차를 입력하실 수 없습니다.";
    private static final String RESULT_MESSAGE_DELIMITER = "\n";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
        validate();
    }

    private void validate() {
        cars.forEach(car -> {
            long numberOfSameNameCars = cars.stream()
                    .filter(car::equals)
                    .count();

            if (isMoreThanTwo(numberOfSameNameCars)) {
                throw new IllegalArgumentException(DUPLICATED_NAME_EXCEPTION_MESSAGE);
            }
        });
    }

    private boolean isMoreThanTwo(long sameNameCars) {
        return sameNameCars >= 2;
    }

    public List<String> getMaxPositionCarNames() {
        int maxPosition = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow()
                .getPosition();

        return cars.stream()
                .filter(car -> car.isWinnerPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void moveEachCar(MoveStrategy moveStrategy) {
        cars.forEach(moveStrategy::move);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(RESULT_MESSAGE_DELIMITER);
        cars.forEach(car -> stringJoiner.add(car.toString()));
        return stringJoiner.toString();
    }
}
