package racingcar.domain;

import java.util.List;
import java.util.StringJoiner;

public class Winner {

    public static final String DELIMITER = ", ";

    private final List<String> winnerNames;

    public Winner(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER);
        winnerNames.forEach(stringJoiner::add);
        return stringJoiner.toString();
    }

}
