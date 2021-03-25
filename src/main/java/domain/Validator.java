package domain;

import io.Printer;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Validator implements ValidatorInterface {
    private static final int MAX_NAME_SIZE = 5;
    private static final String valiNumber = "^[0-9]+$";
    private static final String commaInARow = "^.*(,,).*+$";
    private static final String characterOTN = "^[a-zA-Z,]+$";
    Printer printer;

    public Validator() {
        printer = new Printer();
    }

    @Override
    public boolean validateName(String s) {
        return inputNothing(s)
                && inputCommaInARow(s)
                && inputCharactersOtherThanName(s)
                && startWithComma(s)
                && endWithComma(s)
                && overSizeCharacters(s)
                && inputSameName(s);
    }

    @Override
    public boolean validateNumber(String s) {
        return s.matches(valiNumber);
    }

    @Override
    public boolean inputNothing(String s) {
        if (s.equals("")) {
            printer.printExceptionMessage("INPUT_NOTHING");
            return false;
        }
        return true;
    }

    @Override
    public boolean inputCommaInARow(String s) {
        if (Pattern.matches(commaInARow, s)) { //체크 필요
            printer.printExceptionMessage("INPUT_COMMA_IN_A_ROW");
            return false;
        }
        return true;
    }

    @Override
    public boolean startWithComma(String s) {
        if (s.charAt(0) == ',') {
            printer.printExceptionMessage("START_WITH_COMMA");
            return false;
        }
        return true;
    }

    @Override
    public boolean endWithComma(String s) {
        if (s.charAt(s.length() - 1) == ',') {
            printer.printExceptionMessage("END_WITH_COMMA");
            return false;
        }
        return true;
    }

    @Override
    public boolean inputCharactersOtherThanName(String s) {
        if (!Pattern.matches(characterOTN, s)) {
            printer.printExceptionMessage("INPUT_CHARACTERS_OTHER_THAN_NAME");
            return false;
        }
        return true;
    }

    @Override
    public boolean inputSameName(String s) {
        List<String> carNames = Arrays.asList(s.split(","));
        int sizeOfNameList = carNames.size();

        for (int i = 0; i < sizeOfNameList; i++) {
            if (carNames.subList(i + 1, sizeOfNameList).contains(carNames.get(i))) {
                printer.printExceptionMessage("INPUT_SAME_NAME");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean overSizeCharacters(String s) {
        String[] splitName = s.split(",");
        for (String i : splitName)
            if (i.length() > MAX_NAME_SIZE) {
                printer.printExceptionMessage("OVER_SIZE_CHARACTERS");
                return false;
            }
        return true;
    }

}
