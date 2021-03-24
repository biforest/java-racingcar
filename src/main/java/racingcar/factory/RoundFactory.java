package racingcar.factory;

import racingcar.domain.round.Round;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class RoundFactory {

    private static final String ROUND_NUMBER_EXCEPTION_MESSAGE = "라운드 횟수는 1이상이어야 합니다.";

    public static List<Round> createRounds(int numberOfRounds) {
        validate(numberOfRounds);
        return Arrays.asList((Round[]) Array.newInstance(Round.class, numberOfRounds));
    }

    private static void validate(int numberOfRounds) {
        if (numberOfRounds <= 0) {
            throw new IllegalArgumentException(ROUND_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
