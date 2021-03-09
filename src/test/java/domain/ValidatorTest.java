package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    Validator vd;

    @BeforeEach
    void setup() {
        vd = new Validator();
    }

    @Test
    //이름 유효성 체크
    void validateNameTest(){
        assertThat(vd.validateName("asdasd,,,,")).isEqualTo(false);
    }

    @Test
    //숫자 유효성 체크
    void validateNumberTest(){
        assertThat(vd.validateNumber("1")).isEqualTo(true);
    }

    @Test
    //입력에 아무것도 없을 경우
    void inputNothingTest(){
        assertThat(vd.inputNothing("")).isEqualTo(false);
    }

    @Test
    //쉼표(,)가 연속으로 나올 경우
    void inputCommaInARowTest(){ assertThat(vd.inputCommaInARow("name,,")).isEqualTo(false); }

    @Test
    //쉼표(,)로 시작할 경우
    void startWithCommaTest(){ assertThat(vd.startWithComma(",name")).isEqualTo(false); }

    @Test
    //쉼표(,)로 끝날 경우
    void endWithCommaTest(){ assertThat(vd.endWithComma("name,")).isEqualTo(false); }

    @Test
    //입력에 영문, 쉼표(,) 이외의 문자가 있을 경우
    void inputCharactersOtherThanNameTest(){ assertThat(vd.inputCharactersOtherThanName("name,이름")).isEqualTo(false); }

    @Test
    //같은 이름이 있을 경우
    void inputSameNameTest(){ assertThat(vd.inputSameName("name,name")).isEqualTo(false); }

    @Test
    //이름이 5글자 이상을 경우
    void over5CharactersTest(){ assertThat(vd.over5Characters("person,name")).isEqualTo(false); }

    @ParameterizedTest
    @ValueSource(strings = {"hobihobi,hoho,hoho", "hobihobi,hoho,hoho", "hobihobi,hoho,hoho"})
    void over5CharacterTest(String s) {
        boolean result = vd.over5Characters(s);
        assertThat(result).isEqualTo(false);
    }
}