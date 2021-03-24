package racingcar.factory;

import racingcar.domain.car.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private static final String DELIMITER = ",";

    public static List<Car> createCars(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
