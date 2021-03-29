package ui;

import java.util.stream.Collectors;

import domain.Car;
import domain.Cars;

public class Printer {
    private static final String COLON = " : ";
    private static final String DASH = "-";
    private static final String COMMA = ", ";
    public static final String RESULT_START_MESSAGE = "\n실행 결과";
    private static final String RESULT_END_MESSAGE = "가 최종 우승했습니다.";

    public void printCurrentPositions(Cars cars) {
        String positionsOfCarsPerRound = cars.getCars().stream()
            .map(this::printCurrentPositionOfCar)
            .collect(Collectors.joining());
        System.out.println(positionsOfCarsPerRound);
    }

    private String printCurrentPositionOfCar(Car car) {
        return car.getName() + COLON + DASH.repeat(car.getPosition()) + '\n';
    }

    public void printWinners(Cars winners) {
        int sizeOfWinners = winners.size();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(winners.getCars().get(0).getName());
        if (sizeOfWinners != 1) {
            for (int i = 1; i < sizeOfWinners; i++) {
                stringBuilder.append(COMMA).append(winners.getCars().get(i).getName());
            }
        }
        stringBuilder.append(RESULT_END_MESSAGE);
        System.out.println(stringBuilder);
    }
}
