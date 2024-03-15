package Exceptions;

public class MissingFieldsException extends Exception{
    public MissingFieldsException(String message) {
        super(message);
    }

    public MissingFieldsException() {
        super("Missing fields");
    }
}
