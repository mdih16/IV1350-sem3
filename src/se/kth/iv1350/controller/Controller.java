package se.kth.iv1350.controller;

import se.kth.iv1350.model.*;
import se.kth.iv1350.integration.AccountingSystem;
import se.kth.iv1350.integration.InventorySystem;
import se.kth.iv1350.integration.ItemInformation;

/**
 * Represents the controller. Used to encapsulate the model and integration layer for the view.
 */
public class Controller {
    private final AccountingSystem accSys;
    private final InventorySystem invSys;
    private final SaleLog saleLog;
    private final Register register;
    private Sale sale;
   
    /**
     * Creates a new <code>Controller</code> instance, giving it references to various systems. Also initialises a new sale log and register.
     * @param accSys Reference to the accounting system.
     * @param invSys Reference to the inventory system.
     */
    public Controller(AccountingSystem accSys, InventorySystem invSys)
    {
        this.accSys = accSys;
        this.invSys = invSys;
        saleLog = new SaleLog();
        register = new Register(); 
    }

    /**
     * Initialises a new sale.
     */
    public void startNewSale()
    {
        sale = new Sale();
    }

    /**
     * Enter an item into the sale by using the item identifier.
     * @param itemId The item identifier of the item.
     * @return Information about the item.
     */
    public ItemInformation enterItem(int itemId)
    {
        boolean itemInSale = sale.checkItem(itemId);

        if (itemInSale)
        {
            return sale.increaseQuantity(itemId);
        } 
        else
        {
            ItemInformation itemInformation = invSys.retrieveItem(itemId);
            if (itemInformation != null)
                sale.addItem(itemId, itemInformation);
            return itemInformation;
        }
    }

    /**
     * Get the running total.
     * @return The current running total.
     */
    public double getRunningTotal()
    {
        return sale.getRunningTotal();
    }

    /**
     * End the current sale.
     * @return The total price of the sale.
     */
    public double endSale()
    {
        return sale.endSale();
    }

    /**
     * Pay for the sale.
     * @param amountPaid The amount paid by the customer.
     * @return The change to give back to the customer.
     */
    public double makePayment(double amountPaid)
    {
        saleLog.logSale(sale);
        accSys.updateAccounting(sale);
        invSys.updateInventory(sale);
        double change = register.makePayment(amountPaid, sale);
        return change;
    }
}
