package Exceptions;

/**
 * Exception for missing fields
 */
public class MissingFieldsException extends Exception{
    /**
     * Constructor for MissingFieldsException
     * @param message a string of the message displayed when the exception is thrown
     */
    public MissingFieldsException(String message) {
        super(message);
    }

    /**
     * Constructor for MissingFieldsException
     */
    public MissingFieldsException() {
        super("Missing fields");
    }
}
