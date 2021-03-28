package domain.exception;

public class NotBlankException extends IllegalArgumentException {
    public NotBlankException(String s) {
        super(s);
    }
}
