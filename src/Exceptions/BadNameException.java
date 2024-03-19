package Exceptions;

/**
 * Exception for bad name

 */
public class BadNameException extends Exception {
    private int lineNumber;
    private String fileName;

    /**
     * Constructor of BadNameException
     * @param message a string of the message displayed when the exception is thrown
     * @param lineNumber the line number of the file
     * @param fileName the name of the file
     */
    public BadNameException(String message, int lineNumber, String fileName) {
        super(message);
        this.lineNumber = lineNumber;
        this.fileName = fileName;
    }

    /**
     * Constructor of BadNameException
     * @param message a string of the message displayed when the exception is thrown
     */
    public BadNameException(String message) {
        super(message);
    }

    /**
     * Constructor of BadNameException
     */
    public BadNameException() {
        super("Bad name");
    }

    /**
     * Returns the string representation of the exception
     * @return the string representation of the exception
     */
    @Override
    public String toString() {
        return "Semantic Error: " + super.getMessage() + " in file: " + fileName + " at line: " + lineNumber;
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
}
