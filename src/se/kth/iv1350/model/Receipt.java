package se.kth.iv1350.model;

/**
 * Represents a receipt.
 */
public class Receipt {
    private Sale sale;
    private double amountPaid;
    private double change;

    /**
     * Creates a new <code>Receipt</code> instance.
     * @param sale The sale the receipt is for.
     * @param amountPaid The amount paid by the customer.
     * @param change The change for the transaction.
     */
    Receipt(Sale sale, double amountPaid, double change)
    {
        this.sale = sale;
        this.amountPaid = amountPaid;
        this.change = change;
    }

    /**
     * When an instance of <code>Receipt</code> is printed out this function is called. 
     */
    public String toString()
    {
        StringBuilder receipt = new StringBuilder();
        receipt.append("****************************\nReceipt\n****************************\n");
        receipt.append(sale.getTimeOfSale());
        receipt.append("\n" + "Description" + "\t\t" + "Qty" + "\t\t" + "Price" + "\n");
        for (Item item : sale.getItems())
        {
            receipt.append(item.getItemInformation().getItemDescription() + "\t\t" + item.getQuantity() + "\t\t" + String.format("%.2f", item.getItemInformation().getPrice() * item.getQuantity()) + ":-\n");
        }
        receipt.append("Total:\t\t" + String.format("%.2f", sale.getTotalPrice()) + ":-\n");
        receipt.append("VAT:\t\t" + String.format("%.2f", sale.getTotalVAT()) + ":-\n");
        receipt.append("Paid:\t\t" + String.format("%.2f", amountPaid) + ":-\n");
        receipt.append("Change:\t\t" + String.format("%.2f", change) + ":-");
        return receipt.toString();
    }
}
