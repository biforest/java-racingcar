package racingcar.factory;

import racingcar.domain.car.Car;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    private static final String DUPLICATED_NAME_EXCEPTION_MESSAGE = "중복되는 이름의 차를 입력하실 수 없습니다.";
    private static final String DELIMITER = ",";

    public static List<Car> createCars(String carNames) {
        List<String> names = Arrays.asList(carNames.split(DELIMITER));

        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        validate(names);
        return cars;
    }

    private static void validate(List<String> names) {
        if (names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_EXCEPTION_MESSAGE);
        }
    }
}
