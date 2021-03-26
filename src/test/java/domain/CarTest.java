package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private final String DEFAULT_NAME = "Kim";
    Car car;

    @BeforeEach
    void setUp() { car = new Car(DEFAULT_NAME);
    }

    @Test
    void getPositionTest() {
        assertThat(0).isEqualTo(car.getPosition());
        car.moveForward();
        assertThat(1).isEqualTo(car.getPosition());
        car.moveForward();
        assertThat(2).isEqualTo(car.getPosition());
    }

    @Test
    void getName() {
        assertThat(DEFAULT_NAME).isEqualTo(car.getName());
    }

}