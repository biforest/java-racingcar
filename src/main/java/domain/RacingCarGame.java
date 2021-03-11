package domain;

import java.util.List;

import utils.RandomUtils;

public class RacingCarGame {
    private final List<Car> cars;
    private final int round;

    public RacingCarGame(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    private int makeRandomValue() {
        return RandomUtils.nextInt(0, 9);
    }
}
