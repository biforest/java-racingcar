package racingcar.factory;

import racingcar.domain.round.Round;

import java.util.ArrayList;
import java.util.List;

public class RoundFactory {

    private static final String ROUND_NUMBER_EXCEPTION_MESSAGE = "라운드 횟수는 1이상이어야 합니다.";

    public static List<Round> createRounds(int numberOfRounds) {
        validate(numberOfRounds);
        List<Round> rounds = new ArrayList<>();
        for (int i = 0; i < numberOfRounds; i++) {
            rounds.add(new Round());
        }
        return rounds;
    }

    private static void validate(int numberOfRounds) {
        if (numberOfRounds <= 0) {
            throw new IllegalArgumentException(ROUND_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
