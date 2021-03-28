package domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static final String COMMA = ",";
    public static final String BLANK = " ";

    public CarFactory() {
    }

    public List<Car> createCars(String input) {
        String[] carNames = splitCarNames(input);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private String[] splitCarNames(String input) {
        String inputWithoutBlank = input.replaceAll(BLANK, "");
        return inputWithoutBlank.split(COMMA);
    }
}
