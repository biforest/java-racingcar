package io;

import domain.Validator;

import java.util.Scanner;

public class Receiver {
    private static final String SPLIT_DELIMITER = ",";
    boolean reEnter = false;
    String inputLine = "";
    Scanner scanner = new Scanner(System.in);
    Validator validator = new Validator();

    public String[] receiveName() {
        do{
            inputLine = scanner.nextLine();
            reEnter = validator.isCorrectName(inputLine);
        }while (!reEnter);
        return inputLine.split(SPLIT_DELIMITER);
    }

    public int receiveNumber() {
        do{
            inputLine = scanner.nextLine();
            reEnter = validator.validateNumber(inputLine);
        }while (!reEnter);
        return Integer.parseInt(inputLine);
    }
}
