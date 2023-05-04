package se.kth.iv1350.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SaleLogTest {
    private SaleLog saleLog;

    @BeforeEach
    public void setUp()
    {
        saleLog = new SaleLog();
    }

    @AfterEach
    public void tearDown()
    {
        saleLog = null;
    }

    @Test
    public void testLogSale() 
    {
        Sale sale = new Sale();
        saleLog.logSale(sale);
        try {
            Sale expResult = sale;
            Sale result = saleLog.getSales().get(0);
            assertEquals(expResult, result, "Sale was not logged correctly");
        }
        catch (Exception e) {
            fail("Sale was not logged");
        }
    }
}
