package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarValidatorTest {

    @Test
    public void validateLengthOfCarNames() throws Exception {
        //given
        String[] wrongInput = {"green", "vaseline", "star"};

        //when

        //then
        Assertions.assertThatThrownBy(() -> new CarValidator(wrongInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 5글자 이하만 가능합니다.");
    }
}