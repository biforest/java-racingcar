package domain;

public class AlwaysStopStrategy implements MoveStrategy {
    @Override
    public boolean canMove() {
        return false;
    }
}
