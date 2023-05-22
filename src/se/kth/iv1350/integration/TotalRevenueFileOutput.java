package se.kth.iv1350.integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import se.kth.iv1350.model.SaleObserver;

/**
 * Class that keeps track of total revenue and prints it to a text file.
 */
public class TotalRevenueFileOutput implements SaleObserver {
    private double totalRevenue = 0;
    private PrintWriter revenueFile;

    /**
     * Creates a new instance of <code>TotalRevenueFileOutput</code>. 
     */
    public TotalRevenueFileOutput()
    {
        try 
        {
            revenueFile = new PrintWriter(new FileWriter("pos-revenue-log.txt"), true);
        }
        catch (IOException e)
        {
            System.out.println("Unable to write to revenue log.");
        }
    }

    /**
     * Increases the total revenue whenever a new sale has occured. Writes total revenue to revenue log file.
     * @amount The amount earned in the sale.
     */
    public void newSale(double amount)
    {
        totalRevenue += amount;
        revenueFile.println("Total revenue: " + String.format("%.2f", totalRevenue) + ":-");
    }
}
