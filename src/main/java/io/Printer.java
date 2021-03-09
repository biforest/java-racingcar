package io;

public class Printer {
    Message message = new Message();

    public void printGeneralMessage(String s){
        System.out.println(message.selectMessageFromGeneral(s));
    }

    public void printExceptionMessage(String s){
        System.out.println(message.selectMessageFromException(s));
    }
}
