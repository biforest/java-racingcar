package ui;

import domain.Cars;

public class Printer {
    public static final String RESULT_START_MESSAGE = "\n실행 결과";
    private static final String RESULT_END_MESSAGE = "가 최종 우승했습니다.";

    public void printCurrentPositions(Cars cars) {
        System.out.println(cars.toStringCurrentPositions());
    }

    public void printWinners(Cars winners) {
        System.out.print(winners.toStringWinners());
        System.out.println(Printer.RESULT_END_MESSAGE);
    }
}
