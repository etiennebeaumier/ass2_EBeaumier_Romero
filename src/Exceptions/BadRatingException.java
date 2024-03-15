package Exceptions;

/**
 * Exception for bad rating

 */
public class BadRatingException extends Exception{
    /**
     * Constructor of BadRatingException
     * @param message a string of the message displayed when the exception is thrown
     */
    public BadRatingException(String message) {
        super(message);
    }

    /**
     * Constructor of BadRatingException
     */
    public BadRatingException() {
        super("Bad rating");
    }
}
