package se.kth.iv1350.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;

import se.kth.iv1350.integration.InvalidItemIdException;
import se.kth.iv1350.integration.InventorySystem;

public class ControllerTest {

    @Test
    public void testOperationFailedException() throws InvalidItemIdException
    {
        Controller contr = new Controller(null, new InventorySystem());
        int itemId = 1;
        try
        {
            contr.startNewSale();
            contr.enterItem(itemId);
            fail("No exception thrown even though database is unreachable.");
        }
        catch (OperationFailedException e)
        {
            assertTrue(e.getCause() != null, "No cause specified in OperationFailedException.");
        }
        catch (Exception e)
        {
            fail("OperationFailedException was never thrown");
        }
    }
}
