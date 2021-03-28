package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

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

    private void movePosition(int idx) {
        int randomValue = RandomUtils.generateNumber();

        if (randomValue >= 4) {
            cars.get(idx).moveForward();
        }
    }

    private void proceedOneRound() {
        IntStream.range(0, cars.size()).forEach(this::movePosition);
    }

    public void proceedRounds() {
        System.out.println(RESULT_START_MESSAGE);

        IntStream.range(0, round).forEach(r -> {
            proceedOneRound();
            printCurrentPositions();
        });
    }

    private void printCurrentPositions() {
        for (Car car : cars) {
            System.out.print(car.getName() + COLON);

            IntStream.range(0, car.getPosition()).mapToObj(j -> DASH).forEach(System.out::print);
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
