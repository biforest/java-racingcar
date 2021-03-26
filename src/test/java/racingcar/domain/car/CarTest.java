package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.ThresholdStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarTest {

    @DisplayName("Car 객체 앞으로 전진하는 테스트")
    @Test
    void move() {
        //given
        Car car = new Car("name");
        int prev = car.getPosition().getPosition();

        //when
        car = car.move(new ThresholdStrategy(4, 4));
        int current = car.getPosition().getPosition();

        //then
        assertThat(current).isEqualTo(prev + 1);
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

    @DisplayName("Car 객체의 불변성")
    @Test
    void immutabilityTest() {
        //given
        Car car = new Car("name");

        //when
        Car notMovingCar = car.move(new ThresholdStrategy(10, 4));

        //then
        assertThat(car).isNotEqualTo(notMovingCar);
    }
}
