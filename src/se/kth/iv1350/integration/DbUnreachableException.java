package se.kth.iv1350.integration;

/**
 * Thrown when the database can not be reached
 */
public class DbUnreachableException extends RuntimeException {

    /**
     * Creates a new instance of <code>DbUnreachableException</code>.
     */
    public DbUnreachableException(String msg)
    {
        super(msg);
    }
}
