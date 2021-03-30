package ui;

import java.util.Scanner;

public class Receiver {
    private static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_ROUND = "시도할 횟수는 몇회인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    public String receiveCarNames() {
        System.out.println(REQUEST_CAR_NAME);
        return SCANNER.nextLine();
    }

    public int receiveRound() {
        System.out.println(REQUEST_ROUND);
        return SCANNER.nextInt();
    }
}
