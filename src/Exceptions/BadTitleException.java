package Exceptions;

public class BadTitleException extends Exception{
    public BadTitleException(String message) {
        super(message);
    }

    public BadTitleException() {
        super("Bad title");
    }
}
