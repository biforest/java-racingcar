package domain;

public class Generator {
    private final int MAX_LIMIT_NUMBER = 10; //default value
    public int generateRandomNumber() {
        return (int) ((Math.random() * 10000) % MAX_LIMIT_NUMBER);
    }
}
