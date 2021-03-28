package domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final String EMPTY_STRING = "";

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
        validateInput(input);
        String inputWithoutBlank = input.replaceAll(BLANK, EMPTY_STRING);
        return inputWithoutBlank.split(COMMA);
    }

    private void validateInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
        }
    }
}
