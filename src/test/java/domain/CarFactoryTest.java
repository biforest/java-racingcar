package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarFactoryTest {

    private CarFactory carFactory;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void createCarFactory() throws Exception {
        //given
        String[] carNames = {"green", "tea", "star"};

        //when
        carFactory = new CarFactory(carNames);
        List<Car> cars = carFactory.getCars();

        //then
        assertThat("green").isEqualTo(cars.get(0).getName());
        assertThat("tea").isEqualTo(cars.get(1).getName());
        assertThat("star").isEqualTo(cars.get(2).getName());
    }
}