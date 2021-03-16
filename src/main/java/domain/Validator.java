package domain;

import io.Printer;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Validator implements ValidatorInterface {
    private static final int MAX_NAME_SIZE = 5;
    private static final String ONLY_NUMBER = "^[0-9]+$";
    private static final String COMMA_IN_A_ROW = "^(,,)+$";
    private static final String OTHER_THAN_CHARACTER = "^[a-zA-Z,]+$";

    Printer printer = new Printer();

    @Override
    public boolean validateName(String s) {
        return inputNothing(s)
                && inputCommaInARow(s)
                && inputOtherThanCharacter(s)
                && startWithComma(s)
                && endWithComma(s)
                && overSizeCharacters(s)
                && inputSameName(s);
    }

    @Override
    public boolean validateNumber(String s) {
        return s.matches(ONLY_NUMBER);
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
        if (Pattern.matches(COMMA_IN_A_ROW, s)) {
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
    public boolean inputOtherThanCharacter(String s) {
        if (!Pattern.matches(OTHER_THAN_CHARACTER, s)) {
            printer.printExceptionMessage("INPUT_OTHER_THAN_CHARACTERS");
            return false;
        }
        return true;
    }

    @Override
    public boolean inputSameName(String s) {
        List<String> CAR_NAME_LIST = Arrays.asList(s.split(","));
        int sizeOfNameList = CAR_NAME_LIST.size();

        for (int i = 0; i < sizeOfNameList; i++) {
            if (CAR_NAME_LIST.subList(i + 1, sizeOfNameList).contains(CAR_NAME_LIST.get(i))) {
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
