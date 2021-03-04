package domain;

public interface ValidatorInterface {
    boolean validateName(String s);

    boolean validateNumber(String s);

    String callErrorMessage(String key);
}
