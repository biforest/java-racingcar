package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    private final String[] carNames;
    private final List<Car> cars;

    public CarFactory(String[] carNames) {
        this.carNames = carNames;
        cars = createCars();
    }

    private List<Car> createCars() {
        return Arrays.stream(carNames)
            .map(carName -> new Car(carName))
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
