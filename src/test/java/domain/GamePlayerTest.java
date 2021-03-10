package domain;

import io.Printer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GamePlayerTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    GamePlayer gameplayer;
    Printer printer;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        gameplayer = new GamePlayer();
    }

    @Test
    void checkWhoIsWinnerTest() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("kim");
        Car car2 = new Car("park");
        cars.add(car1);
        cars.add(car2);
        Car[] carArray = new Car[]{car1, car2};

        assertThat(cars).isEqualTo(gameplayer.checkWhoIsWinner(carArray));
    }

    @Test
    void makeArrayAfterGettingNameTest() {
        String input = "kim,park,song";
        InputStream stdin = System.in;

        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            gameplayer = new GamePlayer();
            Car[] cars = gameplayer.makeArrayAfterGettingName();
            assertThat("kim").isEqualTo(cars[0].getName());
            assertThat("park").isEqualTo(cars[1].getName());
            assertThat("song").isEqualTo(cars[2].getName());
        } finally {
            System.setIn(stdin);
        }
    }


    @Test
    void makeCountAfterGettingNumberTest() {
        String input = "5";
        InputStream stdin = System.in;
        int result;

        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            gameplayer = new GamePlayer();
            result = gameplayer.makeCountAfterGettingNumber();
        } finally {
            System.setIn(stdin);
        }

        int expected = 5;
        assertThat(expected).isEqualTo(result);
    }
}