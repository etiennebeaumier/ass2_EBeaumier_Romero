package Exceptions;

/**
 * Exception for bad genre

 */
public class BadGenreException extends Exception{
    /**
     * Constructor
     * @param message a string of the message displayed when the exception is thrown
     */
    public BadGenreException(String message) {
        super(message);
    }

    /**
     * Constructor of BadGenreException
     */
    public BadGenreException() {
        super("Bad genre");
    }
}
