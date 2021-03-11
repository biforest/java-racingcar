package domain;

import java.util.Collections;
import java.util.List;

import utils.RandomUtils;

public class RacingCarGame {
    private static final String RESULT_START_MESSAGE = "\n실행 결과";
    private static final String RESULT_END_MESSAGE = "가 최종 우승했습니다.";
    private static final String COLON = " : ";
    private static final String DASH = "-";
    private final List<Car> cars;
    private final int round;

    public RacingCarGame(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    private int makeRandomValue() {
        return RandomUtils.nextInt(0, 9);
    }

    private void movePosition(int idx) {
        int randomValue = makeRandomValue();
        if (randomValue >= 4) {
            cars.get(idx).moveForward();
        }
    }

    private void proceedOneRound() {
        for (int idx = 0; idx < cars.size(); idx++) {
            movePosition(idx);
        }
    }

    public void proceedRounds() {
        System.out.println(RESULT_START_MESSAGE);
        for (int r = 0; r < round; r++) {
            proceedOneRound();
            printCurrentPositions();
        }
    }

    private void printCurrentPositions() {
        for (Car car : cars) {
            System.out.print(car.getName() + COLON);

            for (int j = 0; j < car.getPosition(); j++) {
                System.out.print(DASH);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWinners() {
        Collections.sort(cars);

        int max = cars.get(0).getPosition();
        System.out.print(cars.get(0).getName());

        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).getPosition() < max) {
                break;
            }
            System.out.print(", " + cars.get(i).getName());
        }
        System.out.println(RESULT_END_MESSAGE);
    }
}
