package se.kth.iv1350.model;

import java.util.ArrayList;

/**
 * Represents a sale log.
 */
public class SaleLog {
    private ArrayList<Sale> sales = new ArrayList<>();
    
    /**
     * Creates a new <code>SaleLog</code> instance.
     */
    public SaleLog()
    {

    }

    /**
     * Log a sale.
     * @param sale The sale to log.
     */
    public void logSale(Sale sale)
    {
        sales.add(sale);
    }

    /**
     * Get the sale log.
     * @return List of all sales.
     */
    public ArrayList<Sale> getSales()
    {
        return sales;
    }
}
