package racingcar.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarFactoryTest {

    @DisplayName(value = "5자리 이하의 정상적인 입력")
    @Test
    void 정상적인_입력() {
        //given
        String carNames = "ab,bc,cd";

        //when
        List<Car> cars = CarFactory.createCars(carNames);

        //then
        assertThat(cars.size()).isEqualTo(3);
    }

    @ValueSource(strings = {"pkalsh,a,b", "ff,fnv,fwoienf", "nvj,kbfkhsdf,dn"})
    @ParameterizedTest(name = "6자리 이상의 비정상적인 입력 [{index}] : input = {0}")
    void 길이가_6자리_이상인_비정상적인_입력(String carNames) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CarFactory.createCars(carNames))
                .withMessage("이름은 5자 이상을 넘길 수 없습니다.");
    }

    @ValueSource(strings = {",,b", ",dasd,"})
    @ParameterizedTest(name = "빈 문자열이 존재하는 비정상적인 입력 [{index}] : input = {0}")
    void 빈문자열이_존재하는_비정상적인_입력(String carNames) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CarFactory.createCars(carNames))
                .withMessage("이름은 공백일 수 없습니다.");
    }

    @DisplayName("콤마만 존재하는 비정상적인 입력")
    @Test
    void 콤마만_존재하는_비정상적인_입력() {
        //given
        String carNames = ",,,";

        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CarFactory.createCars(carNames))
                .withMessage("콤마만 입력할 수는 없습니다.");
    }

    @DisplayName("같은 이름 입력시 예외")
    @Test
    void 같은_이름_등록시_예외() {
        //given
        String carNames = "a,b,a";

        //when, then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CarFactory.createCars(carNames))
                .withMessage("중복되는 이름의 차를 입력하실 수 없습니다.");
    }
}
