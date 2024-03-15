package Exceptions;

/**
 * Exception for when a bad duration is chosen

 */
public class BadDurationException extends Exception{
    /**
     * Constructor for BadDurationException
     * @param message a string of the message displayed when the exception is thrown
     */
    public BadDurationException(String message){
        super(message);
    }

    /**
     * Constructor for BadDurationException
     */
    public BadDurationException (){
        super("Bad Duration chosen");
    }

}
