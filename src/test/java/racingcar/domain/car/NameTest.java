package racingcar.domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void testEquals() {
        //given
        Name name = new Name("name");
        Name anotherName = new Name("name");

        //when then
        assertThat(name).isEqualTo(anotherName);
    }
}