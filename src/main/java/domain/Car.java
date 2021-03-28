package domain;

import domain.exception.NotBlankException;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        validateName();
    }

    public void moveForward() {
        position += 1;
    }

    private void validateName() {
        if (name.length() > 5) {
            throw new IllegalArgumentException(name + ": 자동차 이름은 5글자 이하여야 합니다.");
        }

        if (name.isBlank()) {
            throw new NotBlankException("공백으로만 이루어진 이름을 생성할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return o.position - position;
    }
}
