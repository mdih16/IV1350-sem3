package se.kth.iv1350.integration;

import static org.junit.jupiter.api.Assertions.assertNull;

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
        assertNull(invSys.retrieveItem(itemId), "Invalid item identifier gave result other than null");
    }
}
