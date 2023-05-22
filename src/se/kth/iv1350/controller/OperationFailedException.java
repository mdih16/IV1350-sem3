package se.kth.iv1350.controller;

/**
 * Thrown when some operation fails
 */
public class OperationFailedException extends Exception {

    /**
     * Creates a new instance of <code>OperationFailedException</code>. 
     * @param msg Description of why the exception occured
     * @param cause The cause of why OperationFailedException was thrown
     */
   public OperationFailedException(String msg, Exception cause) 
   {
        super(msg, cause);
   }
}
