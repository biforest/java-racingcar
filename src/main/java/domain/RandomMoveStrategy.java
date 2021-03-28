package domain;

import utils.RandomUtils;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MIN_POWER = 4;

    @Override
    public boolean canMove() {
        int randomValue = makeRandomValue();
        if (randomValue >= MIN_POWER) {
            return true;
        }
        return false;
    }

    private int makeRandomValue() {
        return RandomUtils.nextInt(0, 9);
    }
}
