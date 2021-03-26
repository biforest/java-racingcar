package racingcar.domain.car;

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
        if (cars.size() != new HashSet<>(cars).size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_EXCEPTION_MESSAGE);
        }
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

    public Cars moveEachCar(Random random) {
        List<Car> cars = new ArrayList<>();
        this.cars.forEach(car -> cars.add(car.move(random.nextInt())));
        return new Cars(cars);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(RESULT_MESSAGE_DELIMITER);
        cars.forEach(car -> stringJoiner.add(car.toString()));
        return stringJoiner.toString();
    }
}
