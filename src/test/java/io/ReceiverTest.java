package io;

import io.Receiver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ReceiverTest {

    Receiver rc;

    @BeforeEach
    void setUp() {
        rc = new Receiver();
    }

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