package racingcar.strategy;

import java.util.Random;

public class ThresholdStrategy implements MoveStrategy {
    private static final int UPPER_BOUND = 10;
    public static final String START_NUMBER_EXCEPTION_MESSAGE = "난수 생성은 양수만 가능합니다.";

    private final Random random;
    private final int threshold;
    private final int startNumber;

    public ThresholdStrategy(final int threshold, final int startNumber) {
        validate(startNumber);
        random = new Random();
        this.threshold = threshold;
        this.startNumber = startNumber;
    }

    private void validate(int startNumber) {
        if (startNumber < 0) {
            throw new IllegalArgumentException(START_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean isMove() {
        return startNumber + random.nextInt(UPPER_BOUND - startNumber) >= threshold;
    }
}
