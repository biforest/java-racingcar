package io;

import domain.Car;

import java.util.List;

public class Printer {
    Message message = new Message();

    private static String DEFAULT_SYMBOL = "-";

    public void printProgressWithSymbol(String name, int position) {
        String result = "";
        for(int i = 0;i < position;i++)
            result += DEFAULT_SYMBOL;

        System.out.printf("%5s : %s\n", name, result);
    }

    public void printWinner(String winner) {
        System.out.println(winner + message.selectMessageFromGeneral("FIANL_WINNER"));
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
