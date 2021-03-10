package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car;
    private final String DEFAULT_NAME = "Kim";

    @BeforeEach
    void setUp() {
        car = new Car(DEFAULT_NAME);
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