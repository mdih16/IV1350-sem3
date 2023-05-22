package se.kth.iv1350.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import se.kth.iv1350.integration.ItemInformation;

/**
 * Represents a sale.
 */
public class Sale {
    private LocalDateTime timeOfSale;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<SaleObserver> saleObservers;
    private double runningTotal = 0;
    private double totalVAT = 0;
    private double totalPrice;

    /**
     * Creates a new <code>Sale</code> instance.
     */
    public Sale()
    {
        setTimeOfSale();
    }

    /**
     * Check if an item has already been added to the sale.
     * @param itemId The item identifier.
     * @return True if item is in the sale, false otherwise.
     */
    public boolean checkItem(int itemId)
    {
        for (Item item : items)
        {
            if (item.getId() == itemId)
                return true;
        }    
        return false;
    }

    /**
     * Adds an item to the sale.
     * @param itemId The item identifier.
     * @param itemInformation Information about the item.
     */
    public void addItem(int itemId, ItemInformation itemInformation)
    {
        double itemVAT = calculateItemVAT(itemInformation.getPrice(), itemInformation.getVATRate());
        runningTotal += calculateItemPriceWithVAT(itemInformation.getPrice(), itemVAT);
        totalVAT += itemVAT;
        Item item = new Item(itemId, 1, itemInformation);
        items.add(item); 
    }

    /**
     * Increase the quantity of an item.
     * @param itemId The item identifier.
     * @return Information about the item.
     */
    public ItemInformation increaseQuantity(int itemId)
    {

        int index = 0;
        while (!(items.get(index).getId() == itemId))
            index++;

        Item item = items.get(index);
        ItemInformation itemInformation = item.getItemInformation();

        item.increaseQuantity();
        double itemVAT = calculateItemVAT(itemInformation.getPrice(), itemInformation.getVATRate());
        runningTotal += calculateItemPriceWithVAT(itemInformation.getPrice(), itemVAT);
        totalVAT += itemVAT;
        return itemInformation;
    }


    /**
     * Get the running total.
     * @return The current running total.
     */
    public double getRunningTotal()
    {
        return runningTotal; 
    }

    /**
     * Get the total VAT amount of the sale.
     * @return The total VAT.
     */
    public double getTotalVAT()
    {
        return totalVAT;
    }

    /**
     * Get the total price of the sale.
     * @return The total price.
     */
    public double getTotalPrice()
    {
        return totalPrice;
    }

    /**
     * Get the date and time the sale was done.
     * @return Date and time of sale.
     */
    public LocalDateTime getTimeOfSale()
    {
        return timeOfSale;
    }

    /**
     * Get the items in the current sale.
     * @return List of items.
     */
    public ArrayList<Item> getItems()
    {
        return items;
    }

    /**
     * End the sale.
     * @return Total price of sale with VAT included.
     */
    public double endSale()
    {
        setTotalPrice();
        notifyObservers();
        return totalPrice;
    }

    /**
     * Adds observers to the sale object.
     * @param observer The observing objects.
     */
    public void addSaleObservers(ArrayList<SaleObserver> observers)
    {
        saleObservers = observers;
    }

    private void notifyObservers()
    {
        for (SaleObserver observer : saleObservers)
        {
            observer.newSale(totalPrice);
        }
    }

    private void setTimeOfSale()
    {
        timeOfSale = java.time.LocalDateTime.now();
    }

    private void setTotalPrice()
    {
        totalPrice = runningTotal;
    }

    private double calculateItemVAT(double price, double VATRate)
    {
        return price * VATRate;
    }

    private double calculateItemPriceWithVAT(double price, double itemVAT)
    {
        return price + itemVAT;
    }
}
