package Exceptions;

public class MissingQuotesException extends Exception {
    public MissingQuotesException(String message) {
        super(message);
    }

    public MissingQuotesException() {
        super("Missing quotes");
    }
}
