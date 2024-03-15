package Exceptions;

/**
 * Exception for when a bad duration is chosen
 */
public class BadYearException extends Exception{

    /**
     * Constructor for BadYearException
     * @param message a string of the message displayed when the exception is thrown
     */
    public BadYearException(String message) {
        super(message);
    }

    /**
     * Constructor for BadYearException
     */
    public BadYearException() {
        super("Bad year");
    }
}
