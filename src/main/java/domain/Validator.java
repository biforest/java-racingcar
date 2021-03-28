package domain;

import io.Message;
import io.Printer;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    private static final int MAX_NAME_SIZE = 5;
    private static final String VALID_NUMBER = "^[0-9]+$";
    private static final String COMMA_IN_ROW = "^.*(,,).*+$";
    private static final String CHARACTER = "^[a-zA-Z,]+$";
    private static final Character COMMA = ',';
    private static final String NOTHING = "";

    Printer printer;

    public Validator() {
        printer = new Printer();
    }

    public boolean validateName(String s) {
        return inputNothing(s)
                && inputCommaInARow(s)
                && inputCharactersOtherThanName(s)
                && startWithComma(s)
                && endWithComma(s)
                && overSizeCharacters(s)
                && inputSameName(s);
    }

    public boolean isValidNumber(String s) {
        return s.matches(valiNumber);
    }

    public boolean inputNothing(String s) {
        String messageCode = Message.ExceptionMessages.INPUT_NOTHING.getMessage();

        if (s.equals(NOTHING)) {
            printer.printMessages(messageCode);
            return false;
        }
        return true;
    }

    public boolean inputCommaInARow(String s) {
        String messageCode = Message.ExceptionMessages.INPUT_COMMA_IN_A_ROW.getMessage();

        if (Pattern.matches(commaInARow, s)) {
            printer.printMessages(messageCode);
            return false;
        }
        return true;
    }

    public boolean startWithComma(String s) {
        String messageCode = Message.ExceptionMessages.START_WITH_COMMA.getMessage();

        if (s.charAt(0) == COMMA) {
            printer.printMessages(messageCode);
            return false;
        }
        return true;
    }

    public boolean endWithComma(String s) {
        String messageCode = Message.ExceptionMessages.END_WITH_COMMA.getMessage();

        if (s.charAt(s.length() - 1) == COMMA) {
            printer.printMessages(messageCode);
            return false;
        }
        return true;
    }

    public boolean inputCharactersOtherThanName(String s) {
        String messageCode = Message.ExceptionMessages.INPUT_CHARACTERS_OTHER_THAN_NAME.getMessage();

        if (!Pattern.matches(characterOTN, s)) {
            printer.printMessages(messageCode);
            return false;
        }
        return true;
    }

    public boolean inputSameName(String s) {
        String messageCode = Message.ExceptionMessages.INPUT_SAME_NAME.getMessage();
        List<String> carNames = Arrays.asList(s.split(","));
        int sizeOfNameList = carNames.size();

        for (int i = 0; i < sizeOfNameList; i++) {
            if (carNames.subList(i + 1, sizeOfNameList).contains(carNames.get(i))) {
                printer.printMessages(messageCode);
                return false;
            }
        }
        return true;
    }

    public boolean overSizeCharacters(String s) {
        String messageCode = Message.ExceptionMessages.OVER_SIZE_CHARACTERS.getMessage();
        String[] splitName = s.split(",");

        for (String i : splitName)
            if (i.length() > MAX_NAME_SIZE) {
                printer.printMessages(messageCode);
                return false;
            }
        return true;
    }

}
