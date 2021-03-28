package domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private final String DELIMITER = ",";

    private final List<Car> cars;
    private final String[] carNames;

    public CarFactory(String input) {
        this.carNames = splitCarNames(input);
        trimCarNames();
        cars = createCars();
    }

    private String[] splitCarNames(String answer) {
        return answer.split(DELIMITER);
    }

    private void trimCarNames() {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
    }

    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
