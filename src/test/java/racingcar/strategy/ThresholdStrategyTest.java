package racingcar.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ThresholdStrategyTest {

    @DisplayName("항상 이동하는 경우")
    @Test
    void 항상_이동하는_매개변수_값() {
        //given
        MoveStrategy strategy = new ThresholdStrategy(4, 4);

        //when
        boolean actual = strategy.isMove();

        //then
        assertThat(actual).isTrue();
    }

    @DisplayName("항상 이동하지 않는 경우")
    @Test
    void 항상_이동하지_않는_매개변수_값() {
        //given
        MoveStrategy strategy = new ThresholdStrategy(10, 4);

        //when
        boolean actual = strategy.isMove();

        //then
        assertThat(actual).isFalse();
    }

    @DisplayName("음수값 매개변수 입력시 예외")
    @Test
    void 음수값_매개변수_입력시_예외() {
        //given when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new ThresholdStrategy(4, -1))
                .withMessage("난수 생성은 양수만 가능합니다.");
    }
}
