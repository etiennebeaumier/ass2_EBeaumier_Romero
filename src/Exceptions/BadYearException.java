package Exceptions;

public class BadYearException extends Exception{
    public BadYearException(String message) {
        super(message);
    }

    public BadYearException() {
        super("Bad year");
    }
}
