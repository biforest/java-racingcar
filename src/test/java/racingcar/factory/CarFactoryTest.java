package racingcar.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;

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
    void 비정상적인_입력(String carNames) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CarFactory.createCars(carNames))
                .withMessage("이름은 5자 이상을 넘길 수 없습니다.");
    }
}