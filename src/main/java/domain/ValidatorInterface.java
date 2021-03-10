package domain;

public interface ValidatorInterface {
    boolean validateName(String s);

    boolean validateNumber(String s);


    boolean inputNothing(String s);

    boolean inputCommaInARow(String s);

    boolean startWithComma(String s);

    boolean endWithComma(String s);

    boolean inputCharactersOtherThanName(String s);

    boolean inputSameName(String s);

    boolean overSizeCharacters(String s);
}
