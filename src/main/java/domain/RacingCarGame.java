package domain;

public class RacingCarGame {
    private final Cars cars;

    public RacingCarGame(Cars cars) {
        this.cars = cars;
    }

    public void proceedOneRound(MoveStrategy moveStrategy) {
        cars.moveCars(moveStrategy);
    }

    public Cars chooseWinners() {
        int maxPosition = cars.getMaxPosition();
        return new Cars(cars.findWinners(maxPosition));
    }

    public Cars getCars() {
        return cars;
    }
}
