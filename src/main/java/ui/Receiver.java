package ui;

import java.util.Scanner;

public class Receiver {
    public static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_ROUND = "시도할 횟수는 몇회인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    private String carNames;
    private int round;

    public Receiver() {
        receiveCarNames();
        receiveRound();
    }

    private void receiveCarNames() {
        System.out.println(REQUEST_CAR_NAME);
        carNames = scanner.nextLine();
    }

    private void receiveRound() {
        System.out.println(REQUEST_ROUND);
        round = scanner.nextInt();
    }

    public String getCarNames() {
        return carNames;
    }

    public int getRound() {
        return round;
    }
}
