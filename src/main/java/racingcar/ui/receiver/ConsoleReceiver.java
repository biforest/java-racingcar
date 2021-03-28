package racingcar.ui.receiver;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleReceiver extends Receiver {
    private final Scanner scanner;

    public ConsoleReceiver(InputStream in) {
        scanner = new Scanner(in);
    }

    public String receiveCarNames() {
        return scanner.nextLine();
    }

    public int receiveNumberOfRounds() {
        return scanner.nextInt();
    }

    public void clearBuffer() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
