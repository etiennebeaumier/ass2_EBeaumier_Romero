package Exceptions;

/**
 * Exception for bad name

 */
public class BadNameException extends Exception {
    /**
     * Constructor of BadNameException
     * @param message a string of the message displayed when the exception is thrown
     */
    public BadNameException(String message) {
        super(message);
    }

    /**
     * Constructor of BadNameException
     */
    public BadNameException() {
        super("Bad name");
    }
}
