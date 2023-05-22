package se.kth.iv1350.integration;

/**
 * Thrown when an invalid item identifier is given
 */
public class InvalidItemIdException extends Exception {
    private int invalidId;
   
    /**
     * Creates a new <code>InvalidItemIdException</code> instance.
     * @param invalidId The invalid identifier
     */
    public InvalidItemIdException(int invalidId)
    {
        super("\"" + invalidId + "\"" + " is not a valid ID");
        this.invalidId = invalidId;
    }

    /**
     * Get the invalid item identifer
     * @return Invalid item identifier
     */
    public int getInvalidId()
    {
        return invalidId;
    }
}
