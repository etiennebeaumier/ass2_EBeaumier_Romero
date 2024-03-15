package Exceptions;

public class ExcessFieldsException extends Exception{
    public ExcessFieldsException(String message) {
        super(message);
    }

    public ExcessFieldsException() {
        super("Excess fields");
    }
}
