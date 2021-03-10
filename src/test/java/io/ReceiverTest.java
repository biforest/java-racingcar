package io;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ReceiverTest {
    @Test
    void receiveNameTest() {
        String input = "kim,park,song";
        InputStream stdin = System.in;
        String[] result;

        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Receiver receiver = new Receiver();
            result = receiver.receiveName();
        } finally {
            System.setIn(stdin);
        }

        String[] expected = {"kim", "park", "song"};
        assertThat(expected).isEqualTo(result);
    }

    @Test
    void receiveNumberTest() {
        String input = "5";
        InputStream stdin = System.in;
        int result;

        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Receiver receiver = new Receiver();
            result = receiver.receiveNumber();
        } finally {
            System.setIn(stdin);
        }

        int expected = 5;
        assertThat(expected).isEqualTo(result);
    }
}