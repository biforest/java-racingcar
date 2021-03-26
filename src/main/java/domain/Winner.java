package domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public static String makeWinnerToString(List<Car> cars) {
        StringBuilder winner = new StringBuilder(cars.get(0).getName());

        if(cars.size() > 1) {
            for(int i = 1;i<cars.size();i++) {
                winner.append(", ").append(cars.get(i).getName());
            }
        }

        return winner.toString();
    }

    public static ArrayList<Car> checkWhoIsWinner(ArrayList<Car> cars) {
        ArrayList<Car> winner = new ArrayList<>();
        int maxNumber = 0;

        for (Car car : cars) {
            if(car.isMaxNumber(maxNumber)){
                winner.add(car);
            }
            if (car.isOverMaxNumber(maxNumber)) {
                maxNumber = initWinner(winner, car);
            }
        }

        return winner;
    }

    private static int initWinner(List<Car> winner, Car car) {
        int maxNumber = car.getPosition();
        winner.clear();
        winner.add(car);

        return maxNumber;
    }
}
