package racingcar.domain.car;

import racingcar.domain.car.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
        String actual = car.toString();

        //then
        assertThat(actual).isEqualTo("name : ---");
    }

    @Test
    void 차의_이름이_5자_이상이면_예외를_던진다() {
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("pkalsh"))
                .withMessage("이름은 5자 이상을 넘길 수 없습니다.");
    }

    @Test
    void 빈문자열의_이름이_주어지면_예외를_던진다() {
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(""))
                .withMessage("이름은 공백일 수 없습니다.");
    }
}
