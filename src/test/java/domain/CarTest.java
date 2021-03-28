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
        assertThat(car.getPosition()).isEqualTo(0);
        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(1);
        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void getName() {
        assertThat(DEFAULT_NAME).isEqualTo(car.getName());
    }

}