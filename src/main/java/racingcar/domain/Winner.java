package racingcar.domain;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Winner {

    public static final String DELIMITER = ", ";

    private final List<String> winnerNames;

    public Winner(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    @Override
    public String toString() {
        return String.join(DELIMITER, winnerNames);
    }
}
