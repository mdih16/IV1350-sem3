package se.kth.iv1350.view;

import se.kth.iv1350.controller.Controller;

/**
 * Represents a fake user interface with hardcoded calls to the controller. 
 */
public class View {
    private final Controller contr;

    /**
     * Creates a new <code>View</code> instance. 
     * @param contr The controller that the view communicates with.
     */
    public View(Controller contr)
    {
        this.contr = contr;
    }

    /**
     * A dummy execution of the program with hardcoded calls to the controller.
     */
    public void dummyExecution()
    {
        contr.startNewSale();
        System.out.println("[Displayed] " + contr.enterItem(0));
        System.out.println("[Displayed] Running total: " + String.format("%.2f", contr.getRunningTotal()) + ":-");
        System.out.println("[Displayed] " + contr.enterItem(0));
        System.out.println("[Displayed] Running total: " + String.format("%.2f", contr.getRunningTotal()) + ":-");
        System.out.println("[Displayed] " + contr.enterItem(3));
        System.out.println("[Displayed] Running total: " + String.format("%.2f", contr.getRunningTotal()) + ":-");
        System.out.println("[Displayed] " + contr.enterItem(2));
        System.out.println("[Displayed] Running total: " + String.format("%.2f", contr.getRunningTotal()) + ":-");
        double totalPrice = contr.endSale();
        System.out.println("[Displayed] Total: " + String.format("%.2f", totalPrice) + ":-");
        double change = contr.makePayment(1000);
        System.out.println("[Displayed] Change:" + String.format("%.2f", change) + ":-");
    }
}
