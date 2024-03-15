package Exceptions;

public class BadRatingException extends Exception{
    public BadRatingException(String message) {
        super(message);
    }

    public BadRatingException() {
        super("Bad rating");
    }
}
