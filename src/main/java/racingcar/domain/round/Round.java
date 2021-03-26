package racingcar.domain.round;

import racingcar.domain.car.Cars;
import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private static final String ROUND_NUMBER_EXCEPTION_MESSAGE = "라운드 횟수는 1이상이어야 합니다.";

    private final int numberOfRounds;

    public Round(int numberOfRounds) {
        validate(numberOfRounds);
        this.numberOfRounds = numberOfRounds;
    }

    private static void validate(int numberOfRounds) {
        if (numberOfRounds <= 0) {
            throw new IllegalArgumentException(ROUND_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public List<Cars> process(Cars cars, MoveStrategy moveStrategy) {
        List<Cars> roundResults = new ArrayList<>();
        Cars previousResult = cars;
        for (int i = 0; i < numberOfRounds; i++) {
            Cars result = previousResult.moveEachCar(moveStrategy);
            roundResults.add(result);
            previousResult = result;
        }
        return roundResults;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }
}