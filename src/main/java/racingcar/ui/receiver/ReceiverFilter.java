package racingcar.ui.receiver;

public abstract class ReceiverFilter extends Receiver {
    protected Receiver receiver;

    public ReceiverFilter(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract String receiveCarNames();

    public abstract int receiveNumberOfRounds();

    public void clearBuffer() {
        receiver.clearBuffer();
    }
}
