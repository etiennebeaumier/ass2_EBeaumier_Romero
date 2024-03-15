package Exceptions;

/**
 * Exception for bad score

 */
public class BadScoreException extends Exception{
    /**
     * Constructor of BadScoreException
     * @param message a string of the message displayed when the exception is thrown
     */
    public BadScoreException(String message) {
        super(message);
    }

    /**
     * Constructor of BadScoreException
     */
    public BadScoreException() {
        super("Bad score");
    }
}
