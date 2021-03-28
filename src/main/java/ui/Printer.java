package ui;

import java.util.List;

import domain.Car;

public class Printer {
    public static final String RESULT_START_MESSAGE = "\n실행 결과";
    public static final String RESULT_END_MESSAGE = "가 최종 우승했습니다.";
    public static final String COLON = " : ";
    public static final String DASH = "-";

    public static void printCurrentPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + COLON);

            for (int j = 0; j < car.getPosition(); j++) {
                System.out.print(DASH);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        System.out.print(winners.get(0).getName());
        if (winners.size() != 1) {
            for (int i = 1; i < winners.size(); i++) {
                System.out.print(", " + winners.get(i).getName());
            }
        }
        System.out.println(Printer.RESULT_END_MESSAGE);
    }
}
