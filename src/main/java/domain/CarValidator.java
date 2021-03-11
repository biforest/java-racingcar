package domain;

public class CarValidator {
    private final String[] cars;

    public CarValidator(String[] cars) {
        this.cars = cars;
        validateLengthOfCarNames();
    }

    private void validateLengthOfCarNames() {
        int sizeOfCars = cars.length;

        for (int i = 0; i < sizeOfCars; i++) {
            if (cars[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다.");
            }
        }
    }
}
