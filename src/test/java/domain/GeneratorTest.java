package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GeneratorTest {
    Generator generator;

    @BeforeEach
    void setUp() {
        generator = new Generator();
    }

    @Test
    void generateRandomNumberTest() {
        assertThat(generator.generateRandomNumber()).isBetween(0, 9);
    }
}