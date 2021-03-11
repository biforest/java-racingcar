package domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {

    private RacingCarGame racingCarGame;

    @BeforeEach
    void setUp() {
        int round = 5;
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("lee"));
        cars.add(new Car("chan"));
        cars.add(new Car("gyu"));

        racingCarGame = new RacingCarGame(cars, round);
    }

    @Test
    public void 라운드를_진행한다() throws Exception {
        racingCarGame.proceedRounds();
    }

    @Test
    public void 우승자를_정한다() throws Exception {
        //given
        racingCarGame.proceedRounds();

        //when
        racingCarGame.printWinners();
    }
}
