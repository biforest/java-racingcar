package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domain.exception.NotBlankException;

public class CarTest {

    private Car car;

    @Test
    public void moveForward() throws Exception {
        String name = "green";

        car = new Car(name);
        car.moveForward();
        car.moveForward();

        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    public void 이름이_공백인_경우_NotBlankException을_던진다() {
        String name = " ";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(NotBlankException.class)
                .hasMessageContaining("공백으로만 이루어진 이름을 생성할 수 없습니다.");
    }

    @Test
    public void 이름이_5글자_이상인_경우_Exception을_던진다() throws Exception {
        String name = "softee";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자 이하여야 합니다.");
    }
}
