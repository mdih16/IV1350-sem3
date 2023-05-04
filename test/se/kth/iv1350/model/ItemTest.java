package se.kth.iv1350.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    void testIncreaseQuantity() {
        Item item = new Item(0, 1, null);
        item.increaseQuantity();
        int expResult = 2;
        int result = item.getQuantity();
        assertEquals(expResult, result, "The quantity of item is not increased by one");
    }
}
