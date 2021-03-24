package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    @Test
    void 우승자_1명() {
        //given
        Winner winner = new Winner(Collections.singletonList("a"));

        //when
        String actual = winner.toString();

        //then
        assertThat(actual).isEqualTo("a");
    }

    @Test
    void 우승자_2명이상() {
        //given
        Winner winner = new Winner(Arrays.asList("a", "b", "c"));

        //when
        String actual = winner.toString();

        //then
        assertThat(actual).isEqualTo("a, b, c");
    }
}