package Exceptions;

/**
 * Exception for  bad duration

 */
public class BadDurationException extends Exception{

    private int lineNumber;
    private String fileName;

    /**
     * Constructor for BadDurationException
     * @param message a string of the message displayed when the exception is thrown
     * @param lineNumber the line number in the file
     * @param fileName the name of the file
     */
    public BadDurationException(String message, int lineNumber, String fileName) {
        super(message);
        this.lineNumber = lineNumber;
        this.fileName = fileName;
    }

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
        super("Bad Duration");
    }

    /**
     * Returns the line number of the file
     * @return the line number of the file
     */
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * Sets the line number of the file
     * @param lineNumber the line number of the file
     */
    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    /**
     * Returns the name of the file
     * @return the name of the file
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the name of the file
     * @param fileName the name of the file
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Returns the string representation of the exception
     * @return the string representation of the exception
     */
    @Override
    public String toString() {
        return "Semantic Error: " + super.getMessage() + " in file: " + fileName + " at line: " + lineNumber;
    }

}
