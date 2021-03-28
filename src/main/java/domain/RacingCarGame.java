package domain;

public class RacingCarGame {
    private final Cars cars;
    private Cars winners;

    public RacingCarGame(Cars cars) {
        this.cars = cars;
    }

    public void proceedOneRound(MoveStrategy moveStrategy) {
        cars.moveCars(moveStrategy);
    }

    public Cars chooseWinners() {
        int maxPosition = cars.getMaxPosition();
        return winners = new Cars(cars.findWinners(maxPosition));
    }

    public Cars getCars() {
        return cars;
    }

    public Cars getWinners() {
        return winners;
    }
}
