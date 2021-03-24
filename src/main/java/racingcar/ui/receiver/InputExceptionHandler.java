package racingcar.ui.receiver;

import racingcar.ui.Printer;

import java.util.InputMismatchException;

public class InputExceptionHandler extends ReceiverFilter {

    private final Printer printer;

    public InputExceptionHandler(InputValidator receiver, Printer printer) {
        super(receiver);
        this.printer = printer;
    }

    @Override
    public String receiveCarNames() {
        try {
            return receiver.receiveCarNames();
        } catch (IllegalArgumentException e) {
            printer.printExceptionMessage(e);
        }
        return new InputExceptionHandler((InputValidator) receiver, printer).receiveCarNames();
    }

    @Override
    public int receiveNumberOfRounds() {
        try {
            return receiver.receiveNumberOfRounds();
        } catch (InputMismatchException e) {
            printer.printInputMismatchExceptionMessage();
            receiver.clearBuffer();
        } catch (IllegalArgumentException e) {
            printer.printExceptionMessage(e);
        }
        return new InputExceptionHandler((InputValidator) receiver, printer).receiveNumberOfRounds();
    }
}
