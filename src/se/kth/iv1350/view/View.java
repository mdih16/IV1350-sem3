package se.kth.iv1350.view;

import java.io.IOException;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.controller.OperationFailedException;
import se.kth.iv1350.integration.InvalidItemIdException;
import se.kth.iv1350.integration.TotalRevenueFileOutput;
import se.kth.iv1350.util.LogHandler;

/**
 * Represents a fake user interface with hardcoded calls to the controller. 
 */
public class View {
    private final Controller contr;
    private LogHandler logger;

    /**
     * Creates a new <code>View</code> instance. 
     * @param contr The controller that the view communicates with.
     */
    public View(Controller contr) throws IOException
    {
        this.contr = contr;
        logger = new LogHandler();
        contr.addSaleObserver(new TotalRevenueView());
        contr.addSaleObserver(new TotalRevenueFileOutput());
    }

    /**
     * A dummy execution of the program with hardcoded calls to the controller.
     */
    public void dummyExecution()
    {
        // Sale 1

        contr.startNewSale();

        for (int i = 4; i < 6; i++)
        {
            try 
            {
                System.out.println("[Displayed] " + contr.enterItem(i));
                System.out.println("[Displayed] Running total: " + String.format("%.2f", contr.getRunningTotal()) + ":-");
            }
            catch (InvalidItemIdException e) 
            {
                System.out.println("\"" + e.getInvalidId() + "\"" + " is not a valid ID");
            }
            catch (OperationFailedException e)
            {
                logger.logException(e);
                System.out.println("Something went wrong when trying to add item.");
            }
            catch (Exception e)
            {
                System.out.println("Something went wrong.");
            }

        }

        double totalPrice = contr.endSale();
        System.out.println("[Displayed] Total: " + String.format("%.2f", totalPrice) + ":-");
        double change = contr.makePayment(100);
        System.out.println("[Displayed] Change:" + String.format("%.2f", change) + ":-");
        
        // Sale 2

        contr.startNewSale();

        for (int i = -1; i < 3; i++)
        {
            try 
            {
                System.out.println("[Displayed] " + contr.enterItem(i));
                System.out.println("[Displayed] Running total: " + String.format("%.2f", contr.getRunningTotal()) + ":-");
            }
            catch (InvalidItemIdException e) 
            {
                System.out.println("\"" + e.getInvalidId() + "\"" + " is not a valid ID");
            }
            catch (OperationFailedException e)
            {
                logger.logException(e);
                System.out.println("Something went wrong when trying to add item.");
            }
            catch (Exception e)
            {
                System.out.println("Something went wrong.");
            }
        }

        totalPrice = contr.endSale();
        System.out.println("[Displayed] Total: " + String.format("%.2f", totalPrice) + ":-");
        change = contr.makePayment(150);
        System.out.println("[Displayed] Change:" + String.format("%.2f", change) + ":-");
    }
}
