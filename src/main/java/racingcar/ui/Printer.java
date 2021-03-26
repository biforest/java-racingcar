package racingcar.ui;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.Winner;

import java.util.List;

public class Printer {
    private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_HEADER = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String INPUT_MISMATCH_EXCEPTION_MESSAGE = "라운드 입력으로 숫자만 입력할 수 있습니다.";
    private static final String POSITION_STATE_CHAR = "-";
    private static final String NAME_POSITION_SEPARATOR = " : ";

    public void requestCarName() {
        System.out.println(CAR_NAME_REQUEST_MESSAGE);
    }

    public void requestNumberOfRounds() {
        System.out.println(ROUND_REQUEST_MESSAGE);
    }

    public void printResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public void printWinner(Winner winner) {
        System.out.println(winner + WINNER_MESSAGE);
    }

    public void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printInputMismatchExceptionMessage() {
        System.out.println(INPUT_MISMATCH_EXCEPTION_MESSAGE);
    }

    public void printRoundResults(List<Cars> roundResults) {
        roundResults.forEach(this::printAllCarsState);
    }

    private void printAllCarsState(Cars cars) {
        cars.getCollection().forEach(this::printCarState);
        System.out.println();
    }

    private void printCarState(Car car) {
        String name = car.getName().getValue();
        int position = car.getPosition().getValue();
        System.out.println(name + NAME_POSITION_SEPARATOR + POSITION_STATE_CHAR.repeat(position));
    }
}