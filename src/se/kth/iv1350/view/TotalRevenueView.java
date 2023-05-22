package se.kth.iv1350.view;

import se.kth.iv1350.model.SaleObserver;

/**
 * Class that keeps track of the total revenue.
 */
public class TotalRevenueView implements SaleObserver {
    private double totalRevenue = 0;
    
    /**
     * Increases the total revenue whenever a sale has occured.
     * @param amount The amount earned of the sale.
     */
    public void newSale(double amount)
    {
        totalRevenue += amount;
        System.out.println("[Displayed] Total revenue: " + String.format("%.2f", totalRevenue) + ":-");
    }
}
