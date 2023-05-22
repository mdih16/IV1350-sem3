package se.kth.iv1350.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventorySystemTest {
    private InventorySystem invSys;

    @BeforeEach
    public void setUp()
    {
        invSys = new InventorySystem();
    }

    @AfterEach
    public void tearDown()
    {
        invSys = null;
    }

    @Test
    public void testRetrieveItemInvalidId() {
        int itemId = -1;
        try 
        {
            invSys.retrieveItem(itemId);
            fail("Able to retrieve item with invalid item id.");
        }
        catch (InvalidItemIdException e)
        {
            assertTrue(e.getInvalidId() == itemId, "Wrong item identifier supplied: " + e.getInvalidId());
        }
    }

    @Test
    public void testReachUnreachableDatabase() throws InvalidItemIdException
    {
        int itemId = 1;
        try
        {
            invSys.retrieveItem(itemId);
            fail("No exception thrown even tough database is not reachable.");
        }
        catch (DbUnreachableException e)
        {
            assertTrue(e.getMessage().equals("Not able to reach the database."), "Wrong exception message.");
        }
    }
}
