package racingcar.domain.car;

import racingcar.strategy.MoveStrategy;

import java.util.Objects;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    private Car(Name name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Car move(MoveStrategy moveStrategy) {
        int nextPosition = position.getPosition();
        if (moveStrategy.isMove()) {
            nextPosition++;
        }
        return new Car(name, nextPosition);
    }

    public boolean isWinnerPosition(int winnerPosition) {
        return position.getPosition() == winnerPosition;
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
