package racingcar.strategy;

import java.util.Random;

public class ThresholdStrategy implements MoveStrategy {
    private static final int UPPER_BOUND = 10;

    private final Random random;
    private final int threshold;
    private final int startNumber;

    public ThresholdStrategy(final int threshold, final int startNumber) {
        random = new Random();
        this.threshold = threshold;
        this.startNumber = startNumber;
    }

    @Override
    public boolean isMove() {
        return random.nextInt(UPPER_BOUND) + startNumber >= threshold;
    }
}
