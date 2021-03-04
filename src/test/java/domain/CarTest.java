package domain;

import domain.exception.NotBlankException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void move() {
        //given
        Car car = new Car("name");
        int prev = car.getPosition();

        //when
        car.move();
        int current = car.getPosition();

        //then
        assertThat(current).isEqualTo(prev + 1);
    }

    @Test
    void 차의_이름과_위치상황을_출력_포맷에_맞게_String으로_변환한다() {
        //given
        Car car = new Car("name");
        car.move();
        car.move();
        car.move();

        //when
        String expected = car.toString();

        //then
        assertThat(expected).isEqualTo("name : ---");
    }

    @Test
    void 빈문자열의_이름이_주어지면_NotBlankException을_던진다() {
        //then
        assertThatExceptionOfType(NotBlankException.class)
                .isThrownBy(() -> new Car(""));
    }
}