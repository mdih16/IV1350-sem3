package se.kth.iv1350.startup;

import se.kth.iv1350.integration.AccountingSystem;
import se.kth.iv1350.integration.InventorySystem;
import se.kth.iv1350.view.View;
import se.kth.iv1350.controller.Controller;

/**
 * The class responsible for starting the program.
 */
public class Main {

    /**
     * Main function that initialises objects before the program is run.
     */
    public static void main(String[] args)
    {
        AccountingSystem accSys = new AccountingSystem();
        InventorySystem invSys = new InventorySystem();

        Controller contr = new Controller(accSys, invSys);
        View view = new View(contr);
        view.dummyExecution(); 
    }
}
