package Exceptions;

/**
 * Exception for bad title
 */
public class BadTitleException extends Exception{
    /**
     * Constructor for BadTitleException
     * @param message message to be displayed
     */
    public BadTitleException(String message) {
        super(message);
    }

    /**
     * Constructor for BadTitleException
     */
    public BadTitleException() {
        super("Bad title");
    }
}
