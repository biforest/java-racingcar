package racingcar.domain.car;

public class Name {

    private static final int MAX_LENGTH = 5;
    private static final String BLANK_EXCEPTION_MESSAGE = "이름은 공백일 수 없습니다.";
    private static final String LENGTH_EXCEPTION_MESSAGE = "이름은 " + MAX_LENGTH + "자 이상을 넘길 수 없습니다.";

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    public void validate(String name) {
        validateBlank(name);
        validateLength(name);
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
