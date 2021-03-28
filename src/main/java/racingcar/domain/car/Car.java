package racingcar.domain.car;

import racingcar.strategy.MoveStrategy;

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
}
