package ui;

import java.util.Scanner;

import domain.CarValidator;

public class Input {
    public static final String INPUT_CARS = "경주할 자동차 이름을 입력하세요.";
    public static final String INPUT_ROUND = "시도할 횟수는 몇 회인가요?";

    private Scanner scanner = new Scanner(System.in);

    private String[] cars;
    private int round;

    public Input() {
        getInputCarNames();
        getNumberOfRounds();
    }

    private void getInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String carNames = scanner.nextLine();
        getCarsFromCarNames(carNames);
    }

    private void getCarsFromCarNames(String carNames) {
        String[] cars = carNames.split(",");
        new CarValidator(cars);
        this.cars = cars;
    }

    private void getNumberOfRounds() {
        System.out.println(INPUT_ROUND);
        round = scanner.nextInt();
    }

    public String[] getCars() {
        return cars;
    }

    public int getRound() {
        return round;
    }
}
