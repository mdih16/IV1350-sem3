package se.kth.iv1350.model;

import se.kth.iv1350.integration.Printer;

/**
 * Represent a register.
 */
public class Register {
    private double amount = 0;
    private Printer printer;

    /**
     * Creates a new <code>Register</code> instance.
     */
    public Register()
    {
        printer = new Printer();
    }

    /**
     * Pay for a sale.
     * @param amountPaid The amount paid by the customer.
     * @param sale The sale paid for.
     * @return The change to give back to the customer.
     */
    public double makePayment(double amountPaid, Sale sale)
    {
        double change = calculateChange(amountPaid, sale.getTotalPrice());
        increaseAmountInRegister(sale.getTotalPrice());
        Receipt receipt = new Receipt(sale, amountPaid, change);
        printer.printReceipt(receipt);
        return change;
    }

    /**
     * Get the amount of cash in the register.
     * @return The amount of cash in register.
     */
    public double getAmount()
    {
        return amount;
    }

    private double calculateChange(double amountPaid, double totalPrice)
    {
        return amountPaid - totalPrice;
    }

    private void increaseAmountInRegister(double totalPrice)
    {
        amount += totalPrice;
    }
}
