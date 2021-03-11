package ui;

import java.util.Scanner;

import domain.CarValidator;

public class Input {
    public static final String COMMA = ",";
    private static final Scanner scanner = new Scanner(System.in);

    private String[] carNames;
    private int round;

    public Input() {
        inputCarNames();
        inputNumberOfRounds();
    }

    private void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String input = scanner.nextLine();
        splitCarNames(input);
    }

    private void splitCarNames(String input) {
        String[] carNames = input.split(COMMA);
        new CarValidator(carNames);
        this.carNames = carNames;
    }

    private void inputNumberOfRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        round = scanner.nextInt();
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getRound() {
        return round;
    }
}
