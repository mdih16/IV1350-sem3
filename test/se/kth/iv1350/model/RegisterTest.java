package se.kth.iv1350.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegisterTest {
    private Register register;

    @BeforeEach
    public void setUp()
    {
        register = new Register();
    }

    @AfterEach
    public void tearDown()
    {
        register = null;
    }

    @Test
    public void testMakePaymentReturnValue() {
        Sale sale = new Sale();
        double amountPaid = 100;
        double expResult = 100;
        double result = register.makePayment(amountPaid, sale);
        assertEquals(expResult, result, "Wrong change returned");
    }
}
