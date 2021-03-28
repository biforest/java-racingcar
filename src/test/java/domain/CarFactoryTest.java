package domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {

    private CarFactory carFactory;
    private String input = " lee, chan, gyu ";

    @Test
    public void 차를_생성한다() throws Exception {
        carFactory = new CarFactory();

        List<Car> cars = carFactory.createCars(input);

        Assertions.assertThat(cars.get(0).getName()).isEqualTo("lee");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("chan");
        Assertions.assertThat(cars.get(2).getName()).isEqualTo("gyu");
    }
}
