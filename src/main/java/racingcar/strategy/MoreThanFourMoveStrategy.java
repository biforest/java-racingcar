package racingcar.strategy;

import racingcar.domain.car.Car;

import java.util.Random;

public class MoreThanFourMoveStrategy implements MoveStrategy {

    private static final int THRESHOLD = 4;
    private static final int UPPER_BOUND = 10;

    private final Random random;

    public MoreThanFourMoveStrategy(Random random) {
        this.random = random;
    }

    public void move(Car car) {
        int randomNumber = random.nextInt(UPPER_BOUND);
        if (randomNumber >= THRESHOLD) {
            car.move();
        }
    }

}
