package io;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ReceiverTest {
    @Test
    void receiveLineTest() {
        String result = rc.receiveLine();
        // pobi,crong,honux
        assertThat(result).isEqualTo("pobi,crong,honux");
    }

    @Test
    void receiveNameTest() {
        String[] result = rc.receiveName("pobi,crong,honux");
        assertThat(result).isEqualTo(Arrays.asList("pobi", "crong", "honux"));
    }

    @Test
    void receiveNumberTest() {
        int result = rc.receiveNumber("3");
        assertThat(result).isEqualTo(3);
    }
}