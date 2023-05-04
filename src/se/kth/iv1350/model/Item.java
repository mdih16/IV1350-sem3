package se.kth.iv1350.model;

import se.kth.iv1350.integration.ItemInformation;

/**
 * Represents an item.
 */
public class Item {
    private int itemId;
    private int quantity;
    private ItemInformation itemInformation;
    
    /**
     * Creates a new <code>Item</code> instance.
     * @param itemId The item identifier.
     * @param quantity The quanity of the item.
     * @param itemInformation Information about the item.
     */
    Item(int itemId, int quantity, ItemInformation itemInformation)
    {
        this.itemId = itemId;
        this.quantity = quantity;
        this.itemInformation = itemInformation;
    }

    /**
     * Get the item identifier of an item.
     * @return The item identifier.
     */
    public int getId()
    {
        return itemId;
    }

    /**
     * Get the quanitity of an item
     * @return Quantity of item.
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * Get the item information of an item.
     * @return Information about the item.
     */
    public ItemInformation getItemInformation()
    {
        return itemInformation;
    }

    /**
     * Increase the quanitity of an item by one.
     */
    public void increaseQuantity()
    {
        quantity++;
    }
}
