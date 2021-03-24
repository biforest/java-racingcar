package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarsTest {

    @DisplayName(value = "같은 이름의 Car 객체 등록시 예외")
    @Test
    void 같은_이름_등록시_예외() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("a"));
        cars.add(new Car("b"));
        cars.add(new Car("a"));

        //when, then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Cars(cars))
                .withMessage("중복되는 이름의 차를 입력하실 수 없습니다.");
    }

}