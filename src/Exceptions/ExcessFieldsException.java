package Exceptions;

/**
 * Exception for excess fields
 */
public class ExcessFieldsException extends Exception{
    /**
     * Constructor for ExcessFieldsException
     * @param message a string of the message displayed when the exception is thrown
     */
    public ExcessFieldsException(String message) {
        super(message);
    }

    /**
     * Constructor for ExcessFieldsException
     */
    public ExcessFieldsException() {
        super("Excess fields");
    }
}
