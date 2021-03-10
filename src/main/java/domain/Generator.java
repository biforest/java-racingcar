package domain;

public class Generator {
    private int MAX_LIMIT_NUMBER = 10; //default value

    Generator() {}

    Generator(int maxNum) {
        this.MAX_LIMIT_NUMBER = maxNum;
    }

    public int generateRandomNumber() {
        return (int) ((Math.random() * 10000) % MAX_LIMIT_NUMBER);
    }
}
