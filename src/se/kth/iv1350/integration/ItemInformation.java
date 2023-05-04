package se.kth.iv1350.integration;

/**
 * Represents information about an item.
 */
public class ItemInformation {
    private final double price;
    private final double VATRate;
    private final String itemDescription;

    /**
     * Creates a new <code>ItemInformation</code> instance.
     * @param price The price of the item.
     * @param VATRate The VAT rate of the item.
     * @param itemDescription A description of the item.
     */
    ItemInformation(double price, double VATRate, String itemDescription)
    {
        this.price = price;
        this.VATRate = VATRate;
        this.itemDescription = itemDescription;
    }

    /**
     * When an instance of <code>ItemInformation</code> is printed out this is called.
     */
    public String toString()
    {
        return itemDescription + " " + price + ":-";
    }

    /**
     * Get the price of the item.
     * @return The price of the item
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Get the VAT rate of the item.
     * @return The VAT rate of the item.
     */
    public double getVATRate()
    {
        return VATRate;
    }

    /**
     * Get the item description of the item.
     * @return The item description.
     */
    public String getItemDescription()
    {
        return itemDescription;
    }
}
