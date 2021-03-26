package racingcar.domain.car;

public class Position implements Comparable<Position> {
    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public int getValue() {
        return position;
    }

    @Override
    public int compareTo(Position o) {
        return o.position - position;
    }
}
