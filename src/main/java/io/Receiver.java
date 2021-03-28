package io;

import domain.Validator;

import java.util.Scanner;

public class Receiver {
    boolean reEnter = false;
    private String inputLine = "";
    private Scanner scanner = new Scanner(System.in);
    private Validator validator = new Validator();

    public String[] receiveName() {
        do{
            inputLine = scanner.nextLine();
            reEnter = validator.validateName(inputLine);
        }while (!reEnter);
        return inputLine.split(",");
    }

    public int receiveNumber() {
        do{
            inputLine = scanner.nextLine();
            reEnter = validator.isValidNumber(inputLine);
        }while (!reEnter);
        return Integer.parseInt(inputLine);
    }
}
