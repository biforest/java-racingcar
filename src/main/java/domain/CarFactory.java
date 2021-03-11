package domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static final String COMMA = ",";
    public static final String BLANK = " ";
    private final List<Car> cars;
    private final String[] carNames;

    public CarFactory(String input) {
        this.carNames = splitCarNames(input);
        cars = createCars();
    }

    private String[] splitCarNames(String input) {
        String s = input.replaceAll(BLANK, "");
        return s.split(COMMA);
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
