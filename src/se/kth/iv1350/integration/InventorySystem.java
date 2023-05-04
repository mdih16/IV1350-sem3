package se.kth.iv1350.integration;

import java.util.ArrayList;
import se.kth.iv1350.model.Sale;

/**
 * Represents an inventory system handler. 
 */
public class InventorySystem {
    private ArrayList<ItemInformation> itemDatabase = new ArrayList<>();

    /**
     * Creates a new <code>InventorySystem</code> instance and adds new items to an array as this is not a real inventory system.
     */
    public InventorySystem()
    {
        itemDatabase.add(new ItemInformation(24.90, 0.06, "Morötter 1kg"));
        itemDatabase.add(new ItemInformation(12.95, 0.06, "Krossade Tomater 500g"));
        itemDatabase.add(new ItemInformation(76.00, 0.12, "Jasminris 2kg"));
        itemDatabase.add(new ItemInformation(158.40, 0.12, "Blandfärs 1,6kg"));
        itemDatabase.add(new ItemInformation(15.95, 0.25, "Geléhallon 170g"));
        itemDatabase.add(new ItemInformation(31.95, 0.25, "Cheezdoodles 225g"));
    }

    /**
     * Retrieves information about some item.
     * @param itemId The item identifier of the item.
     * @return Information about the item.
     */
    public ItemInformation retrieveItem(int itemId)
    {
        if (itemId < 0 || itemId >= itemDatabase.size())
            return null;
        else
            return itemDatabase.get(itemId);
    }

    /**
     * Update the inventory system with information about a sale. This is not a real inventory system and does not actually update anything.
     * @param sale The sale with information to update the inventory.
     */
    public void updateInventory(Sale sale)
    {

    }
}
