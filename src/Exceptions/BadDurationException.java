package Exceptions;

public class BadDurationException extends Exception{
    public BadDurationException(String message){
        super(message);
    }
    public BadDurationException (){
        super("Bad Duration chosen");
    }

}
