package racingcar.domain.car;

import java.util.Objects;

public class Car {
    private final Name name;
    private int position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = 0;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position = position + 1;
    }

    public boolean isWinnerPosition(int winnerPosition) {
        return position == winnerPosition;
    }

    @Override
    public String toString() {
        return name.getName() + " : " + "-".repeat(Math.max(0, position));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
