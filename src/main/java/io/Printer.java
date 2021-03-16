package io;

import domain.Car;

import java.util.List;

public class Printer {
    private Message message = new Message();

    private static String DEFAULT_SYMBOL = "-";

    public void printProgressWithSymbol(String name, int position) {
        String result = "";
        for(int i = 0;i < position;i++)
            result += DEFAULT_SYMBOL;

        System.out.printf("%5s : %s\n", name, result);
    }

    public String makeWinnerToString(List<Car> cars) {
        String winner = cars.get(0).getName();

        if(cars.size() > 1) {
            for(int i = 1;i<cars.size();i++) {
                winner += ", " + cars.get(i).getName();
            }
        }

        return winner;
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
}
