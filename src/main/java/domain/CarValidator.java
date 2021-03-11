package domain;

public class CarValidator {
    private final String[] carNames;

    public CarValidator(String[] carNames) {
        this.carNames = carNames;
        validateLengthOfCarNames();
    }

    private void validateLengthOfCarNames() {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다.");
            }
        }
    }
}
