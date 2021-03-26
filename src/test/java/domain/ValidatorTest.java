package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    private final String NORMAL_INPUT_FOR_NAME = "Park,Song,Kim,Jay";
    private final String NORMAL_INPUT_FOR_NUMBER = "5";
    Validator vd;

    @BeforeEach
    void setup() {
        vd = new Validator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123,!@a,BDs5", ",,asd,asd,", NORMAL_INPUT_FOR_NAME})
        //이름 유효성 체크
    void validateNameTest(String s) {
        assertThat(vd.isCorrectName(s)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"it's not a number", "what else?", NORMAL_INPUT_FOR_NUMBER})
        //숫자 유효성 체크
    void validateNumberTest(String s) {
        assertThat(vd.validateNumber(s)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", NORMAL_INPUT_FOR_NAME})
        //입력에 아무것도 없을 경우
    void inputNothingTest(String s) {
        assertThat(vd.inputNothing(s)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {",,,,,,", "kim,song,,park", NORMAL_INPUT_FOR_NAME})
        //쉼표(,)가 연속으로 나올 경우
    void inputCommaInARowTest(String s) {
        assertThat(vd.inputCommaInARow(s)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {",Kim,Park,Song", ",,Park,Song,Kim", NORMAL_INPUT_FOR_NAME})
        //쉼표(,)로 시작할 경우
    void startWithCommaTest(String s) {
        assertThat(vd.startWithComma(s)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hobihobi,hoho,hoho,", "asdfgg,asdfghj,zxcvbn,,,", NORMAL_INPUT_FOR_NAME})
        //쉼표(,)로 끝날 경우
    void endWithCommaTest(String s) {
        assertThat(vd.endWithComma(s)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hobㅁ,hoho,hoho", "asd5,asdfghj,zxcvbn", NORMAL_INPUT_FOR_NAME})
        //입력에 영문, 쉼표(,) 이외의 문자가 있을 경우
    void inputCharactersOtherThanNameTest(String s) {
        assertThat(vd.inputOtherThanCharacter(s)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hobihobi,hoho,hoho", "asdfgg,asdfgg,zxcvbn", NORMAL_INPUT_FOR_NAME})
        //같은 이름이 있을 경우
    void inputSameNameTest(String s) {
        assertThat(vd.inputSameName(s)).isEqualTo(false);
    }

    @ParameterizedTest
    //이름이 5글자 이상을 경우
    @ValueSource(strings = {"hobihobi,hoho,hoho", "asdfgg,asdfghj,zxcvbn", NORMAL_INPUT_FOR_NAME})
    void overSizeCharacterTest(String s) {
        assertThat(vd.overSizeCharacters(s)).isEqualTo(false);
    }
}