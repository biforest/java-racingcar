package io;

import domain.Car;

import java.util.List;

public class Printer {
    Message message = new Message();

    private static String DEFAULT_SYMBOL = "-";

    public void printProgress(String name, String progress) {
        System.out.printf("%5s : %s\n", name, progress);
    }

    public void printWinner(String winner) {
        System.out.println(winner + Message.GeneralMessages.FIANL_WINNER.getMessage());
    }

    public void printGeneralMessage(String s){
        System.out.println(message.selectMessageFromGeneral(s));
    }

    public void printExceptionMessage(String s){
        System.out.println(message.selectMessageFromException(s));
    }

    public void printMessages(String message) {
        System.out.println(message);
    }
}
