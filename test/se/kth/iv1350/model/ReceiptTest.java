package se.kth.iv1350.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReceiptTest {

    @BeforeEach
    public void setUp()
    {
    }

    @AfterEach
    public void tearDown()
    {
    }

    @Test
    void testToString() {
        Sale sale = new Sale();
        double amountPaid = 50;
        double change = 50;
        Receipt receipt = new Receipt(sale, amountPaid, change);
        String expResult = "****************************\nReceipt\n****************************\n"
                            + sale.getTimeOfSale() 
                            + "\n" + "Description" + "\t\t" + "Qty" + "\t\t" + "Price" + "\n"
                            + "Total:\t\t" + String.format("%.2f", (double) 0) + ":-\n"
                            + "VAT:\t\t" + String.format("%.2f", (double) 0 )+ ":-\n"
                            + "Paid:\t\t" + String.format("%.2f", amountPaid) + ":-\n"
                            + "Change:\t\t" + String.format("%.2f", change) + ":-";
        String result = receipt.toString();
        assertTrue(result.contains(expResult), "Wrong printout");
        assertTrue(result.contains(String.format("%.2f", (double) 0)), "Wrong total price on receipt");
        assertTrue(result.contains(String.format("%.2f", (double) 0)), "Wrong VAT on receipt");
        assertTrue(result.contains(String.format("%.2f", amountPaid)), "Wrong amount paid on receipt");
        assertTrue(result.contains(String.format("%.2f", change)), "Wrong change on receipt");
    }
}
