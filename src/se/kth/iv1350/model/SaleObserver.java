package se.kth.iv1350.model;

/**
 * Interface used to notify observers whenever a new sale is made.
 */
public interface SaleObserver {

    /**
     * Notifies observers that a new sale has occured.
     * @param amount The <code>amount</code> made from the sale. 
     */
    void newSale(double amount);
}
