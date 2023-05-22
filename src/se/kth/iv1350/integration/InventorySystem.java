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
        itemDatabase.add(new ItemInformation(22.95, 0.06, "Tomater 1kg"));
        itemDatabase.add(new ItemInformation(76.00, 0.12, "Jasminris 2kg"));
        itemDatabase.add(new ItemInformation(158.40, 0.12, "Blandfärs 1,6kg"));
        itemDatabase.add(new ItemInformation(15.95, 0.25, "Geléhallon 170g"));
        itemDatabase.add(new ItemInformation(31.95, 0.25, "Cheezdoodles"));
    }

    /**
     * Retrieves information about some item.
     * @param itemId The item identifier of the item.
     * @return Information about the item.
     * @throws InvalidItemIdException When item with given item identifier is not found in the system.
     * @throws DbUnreachableException When the program is not able to reach the database. 
     */
    public ItemInformation retrieveItem(int itemId) throws InvalidItemIdException
    {
        if (itemId < 0 || itemId >= itemDatabase.size())
            throw new InvalidItemIdException(itemId);
        else if (itemId == 1)
            throw new DbUnreachableException("Not able to reach the database.");
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
