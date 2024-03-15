package Exceptions;

/**
 * Exception for missing quotes
 */
public class MissingQuotesException extends Exception {
    /**
     * Constructor for MissingQuotesException
     * @param message a string of the message displayed when the exception is thrown
     */
    public MissingQuotesException(String message) {
        super(message);
    }

    /**
     * Constructor for MissingQuotesException
     */
    public MissingQuotesException() {
        super("Missing quotes");
    }
}
