package domain;

public class AlwaysMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove() {
        return true;
    }
}
