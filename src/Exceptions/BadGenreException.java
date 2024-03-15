package Exceptions;

public class BadGenreException extends Exception{
    public BadGenreException(String message) {
        super(message);
    }

    public BadGenreException() {
        super("Bad genre");
    }
}
