package se.kth.iv1350.controller;

import se.kth.iv1350.model.*;

import java.util.ArrayList;

import se.kth.iv1350.integration.AccountingSystem;
import se.kth.iv1350.integration.DbUnreachableException;
import se.kth.iv1350.integration.InvalidItemIdException;
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
    private ArrayList<SaleObserver> saleObservers = new ArrayList<>();
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
        sale.addSaleObservers(saleObservers);
    }

    /**
     * Enter an item into the sale by using the item identifier.
     * @param itemId The item identifier of the item.
     * @return Information about the item.
     * @throws InvalidItemIdException when item with given item identifier is not found in the system.
     * @throws OperationFailedException when some operation was not able to finish succesfully.
     */

    public ItemInformation enterItem(int itemId) throws InvalidItemIdException, OperationFailedException
    {
        boolean itemInSale = sale.checkItem(itemId);

        if (itemInSale)
        {
            return sale.increaseQuantity(itemId);
        } 
        else
        {
            try 
            {
                ItemInformation itemInformation = invSys.retrieveItem(itemId);
                sale.addItem(itemId, itemInformation);
                return itemInformation;
            }
            catch (DbUnreachableException e)
            {
                throw new OperationFailedException("Something went wrong when trying to add the item.", e);
            }
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

    /**
     * Adds observer to saleObservers.
     * @param observer The object observing.
     */
    public void addSaleObserver(SaleObserver observer)
    {
        saleObservers.add(observer);
    }
}
