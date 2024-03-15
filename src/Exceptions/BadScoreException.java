package Exceptions;

public class BadScoreException extends Exception{
    public BadScoreException(String message) {
        super(message);
    }

    public BadScoreException() {
        super("Bad score");
    }
}
