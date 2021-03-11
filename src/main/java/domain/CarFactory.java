package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    private final String[] carNames;
    private int numberOfCars;
    private List<Car> cars;

    public CarFactory(String[] carNames) {
        this.carNames = carNames;
        numberOfCars = carNames.length;
        createCars();
    }

    private void createCars() {
        cars = Arrays.stream(carNames)
            .map(carName -> new Car(carName))
            .collect(Collectors.toList());
    }
}
