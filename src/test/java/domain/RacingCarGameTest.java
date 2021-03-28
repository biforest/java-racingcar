package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {

    private RacingCarGame racingCarGame;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("green"));
        cars.add(new Car("bean"));
        cars.add(new Car("ceci"));

        racingCarGame = new RacingCarGame(cars);
    }

    @Test
    public void 라운드_하나를_진행한다() throws Exception {
        MoveStrategy moveStrategy = new AlwaysMoveStrategy();

        racingCarGame.proceedOneRound(moveStrategy);

        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(1);
        assertThat(cars.get(2).getPosition()).isEqualTo(1);
    }

    @Test
    public void 우승자를_정한다() throws Exception {
        // given
        MoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();
        MoveStrategy alwaysStopStrategy = new AlwaysStopStrategy();

        cars.get(0).moveForward(alwaysStopStrategy);
        cars.get(1).moveForward(alwaysMoveStrategy);
        cars.get(2).moveForward(alwaysMoveStrategy);

        // when
        racingCarGame.chooseWinners();
        List<Car> winners = racingCarGame.getWinners();

        // then
        assertThat(winners.get(0).getName()).isEqualTo("bean");
        assertThat(winners.get(1).getName()).isEqualTo("ceci");
    }
}
