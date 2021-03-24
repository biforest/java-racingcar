package racingcar.ui.receiver;

import java.util.regex.Pattern;

public class InputValidator extends ReceiverFilter {

    private static final String ROUND_NUMBER_EXCEPTION_MESSAGE = "라운드 횟수는 1이상이어야 합니다.";
    private static final String CAR_NAMES_EXCEPTION_MESSAGE = "자동차 이름의 입력은 콤마로 구분하여 하나 이상 입력해주세요.";

    public InputValidator(Receiver receiver) {
        super(receiver);
    }

    @Override
    public String receiveCarNames() {
        String carNames = receiver.receiveCarNames();
        if (!isValidPattern(carNames)) {
            throw new IllegalArgumentException(CAR_NAMES_EXCEPTION_MESSAGE);
        }
        return carNames;
    }

    private boolean isValidPattern(String carNames) {
        return Pattern.matches("[^,]+(,[^,]+)*", carNames);
    }

    @Override
    public int receiveNumberOfRounds() {
        int numberOfRounds = receiver.receiveNumberOfRounds();
        if (isLessThanZero(numberOfRounds)) {
            throw new IllegalArgumentException(ROUND_NUMBER_EXCEPTION_MESSAGE);
        }
        return numberOfRounds;
    }

    private boolean isLessThanZero(int numberOfRounds) {
        return numberOfRounds <= 0;
    }
}
