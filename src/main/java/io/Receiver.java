package io;

import java.util.Scanner;

public class Receiver {
    Scanner scanner = new Scanner(System.in);

    public String receiveLine(){
        return scanner.nextLine();
    }

    public String[] receiveName(String s) {
        //ValidationcheckforString

        return s.split(",");
    }

    public int receiveNumber(String s) {

        //Validation Check for number
        //if it's true

        return Integer.parseInt(s);
    }


}
