package domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MIN_POWER = 4;
    private static final int RANDOM_INT_BOUND = 10;
    private static final Random RANDOM = new Random();

    @Override
    public boolean canMove() {
        int randomValue = makeRandomValue();
        return randomValue >= MIN_POWER;
    }

    private int makeRandomValue() {
        return RANDOM.nextInt(RANDOM_INT_BOUND);
    }
}
