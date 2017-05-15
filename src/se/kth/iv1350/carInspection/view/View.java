package se.kth.iv1350.carInspection.view;

import se.kth.iv1350.carInspection.controller.Controller;
import se.kth.iv1350.carInspection.controller.OperationFailedException;
import se.kth.iv1350.carInspection.integration.ItemsForInspections;
import se.kth.iv1350.carInspection.model.CreditCard;

import java.time.YearMonth;
import java.util.List;

/**
 * Placeholder for the view.
 */

public class View {
    private Controller controller;

    /**
     * Constructor for new instance that will use the specified controller for all system operations.
     *
     * @param controller Controller for system operations.
     */

    public View(Controller controller){
        this.controller = controller;
    }

    /**
     * Calls for all system operations and input, output for inspector.
     */
    public void start () {
        int cost;
        controller.initiateNewInspection();
        String regNo = "ABS123";

        try {
            cost = controller.checkForInspections(regNo);
            System.out.println("Total cost for inspection: " + cost);
        }catch (OperationFailedException e){
            System.out.println("Not Valid register number");
        }


        int pin = 1234;
        String number = "5461234";
        String holder = "Anders Andersson";
        YearMonth expiryDate = YearMonth.of(2018,2) ;
        int CVC = 456;
        CreditCard creditCard = new CreditCard(pin, number, holder, expiryDate, CVC);
        controller.payment(creditCard,cost);



        java.util.Scanner in = new java.util.Scanner(System.in);
        List<ItemsForInspections> inspectionList = controller.startInspections();
        for(int i = 0; i < inspectionList.size();i++ ){
            System.out.println("Part to inspect: " + inspectionList.get(i).getNameOfInspection());
            System.out.println("Enter result, Pass or Fail.");
            controller.saveResult(i, in.next());
        }
        controller.getResults();
        controller.initiateNewInspection();
    }

}
