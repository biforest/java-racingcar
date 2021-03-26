package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void moveForward() {
        this.position++;
    }

    public boolean isMaxNumber(int maxNumber) {
        return this.position == maxNumber;
    }

    public boolean isOverMaxNumber(int maxNumber) {
        return this.position > maxNumber;
    }

    public String getProgressWithSymbol() {
        String progress = "";
        for(int i = 0;i < this.position;i++)
            progress += "-";

        return progress;
    }
}
