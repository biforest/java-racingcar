package domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private int maxNumber = 0;
    private final List<Car> result = new ArrayList<>();

    public List<Car> checkWinner(Car[] cars) {
        findMaxNumber(cars);
        judgeWinner(cars);
        return result;
    }

    public void findMaxNumber(Car[] cars) {
        int firstPlacePosition = maxNumber;

        for (Car car : cars) {
            if (car.getPosition() > firstPlacePosition)
                firstPlacePosition = car.getPosition();
        }
        maxNumber = firstPlacePosition;
    }

    public void judgeWinner(Car[] cars) {
        for (Car car : cars) {
            if (car.getPosition() == maxNumber)
                result.add(car);
        }
    }
}
