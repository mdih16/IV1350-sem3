package se.kth.iv1350.integration;

import se.kth.iv1350.model.Receipt;

/**
 * Represents a receipt printer.
 */
public class Printer {

    /**
     * Creates a new <code>Printer</code> instance.
     */
    public Printer()
    {

    }
    
    /**
     * Prints a receipt.
     * @param receipt The receipt to print.
     */
    public void printReceipt(Receipt receipt)
    {
        System.out.println(receipt);
    }
}
