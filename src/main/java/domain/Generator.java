package domain;

public class Generator {
    private static final int MAX_LIMIT_NUMBER = 10;

    public int generateRandomNumber() {
        return (int) ((Math.random() * 10000) % MAX_LIMIT_NUMBER);
    }
}
