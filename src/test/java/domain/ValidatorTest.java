package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator vd;

    @BeforeEach
    void setup() {
        vd = new Validator();
    }

    @Test
    void validateNameTest(){
        boolean result = vd.validateName("asdasd,,,,");
        assertThat(result).isEqualTo(false);
    }


    @Test
    void validateNumberTest(){
        boolean result = vd.validateNumber("1e");
        assertThat(result).isEqualTo(false);
    }

    @Test
    void callErrorMessageTest(){
        String result = vd.callErrorMessage("asdasdasd");
        assertThat(result).isEqualTo("아무 문자도 입력되지 않았습니다.");

    }
}