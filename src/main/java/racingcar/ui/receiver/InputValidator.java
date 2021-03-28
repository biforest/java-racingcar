package racingcar.ui.receiver;

import java.util.regex.Pattern;

public class InputValidator extends ReceiverFilter {

    private static final String ONLY_COMMA_EXCEPTION_MESSAGE = "자동차 이름은 콤마만 입력할 수 없습니다.";

    public InputValidator(Receiver receiver) {
        super(receiver);
    }

    @Override
    public String receiveCarNames() {
        String carNames = receiver.receiveCarNames();
        if (isOnlyComma(carNames)) {
            throw new IllegalArgumentException(ONLY_COMMA_EXCEPTION_MESSAGE);
        }
        return carNames;
    }

    private boolean isOnlyComma(String carNames) {
        return Pattern.matches(",+", carNames);
    }

    @Override
    public int receiveNumberOfRounds() {
        return receiver.receiveNumberOfRounds();
    }
}
