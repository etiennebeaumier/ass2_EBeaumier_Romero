package Exceptions;

public class BadNameException extends Exception {
    public BadNameException(String message) {
        super(message);
    }

    public BadNameException() {
        super("Bad name");
    }
}
