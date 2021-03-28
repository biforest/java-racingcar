package io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MessageTest {

    Message message;

    @BeforeEach
    void setUp() {
        message = new Message();
    }

    @Test
    void selectMessageFromGeneral() {
        String result = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
        assertThat(message.selectMessageFromGeneral("INPUT_NAMEOFCAR")).isEqualTo(result);
    }

    @Test
    void selectMessageFromException() {
        String result = "아무 문자도 입력되지 않았습니다.";
        assertThat(message.selectMessageFromException("INPUT_NOTHING")).isEqualTo(result);
    }
}