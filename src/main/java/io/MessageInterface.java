package io;

public interface MessageInterface {

    private void generalMessageList() {
    }

    private void exceptionMessageList() {
    }

    String selectMessageFromGeneral(String Keyword);

    String selectMessageFromException(String Keyword);
}
