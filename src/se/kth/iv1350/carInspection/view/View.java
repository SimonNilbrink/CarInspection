package se.kth.iv1350.carInspection.view;

import se.kth.iv1350.carInspection.controller.Controller;
import se.kth.iv1350.carInspection.controller.OperationFailedException;
import se.kth.iv1350.carInspection.integration.ItemsForInspections;
import se.kth.iv1350.carInspection.model.CreditCard;
import se.kth.iv1350.carInspection.util.LogHandler;

import java.io.IOException;
import java.time.YearMonth;
import java.util.List;
import java.util.Scanner;


/**
 * Placeholder for the view.
 */

public class View {
    private Controller controller;
    ErrorMessageHandler errorMsg = new ErrorMessageHandler();
    private LogHandler log;


    /**
     * Constructor for new instance that will use the specified controller for all system operations.
     *
     * @param controller Controller for system operations.
     */

    public View(Controller controller) throws IOException{
        this.controller = controller;
        this.log = new LogHandler();
    }

    /**
     * Calls for all system operations and input, output for inspector.
     */
    public void start () {
        int cost = 0;
        controller.initiateNewInspection();
        String regNo;
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter registration number"); //ABS123 is the only valid reg number.
            regNo = in.next();
            try {
                controller.checkValidRegNo(regNo);
                break;
            }catch (OperationFailedException e){
                exceptionHandler("Not Valid registration number",e);
            }
        }
        cost = controller.checkForInspections();
        System.out.println("Total cost for inspection: " + cost);

        int pin = 1234;
        String number = "5461234";
        String holder = "Anders Andersson";
        YearMonth expiryDate = YearMonth.of(2018,2) ;
        int CVC = 456;
        CreditCard creditCard = new CreditCard(pin, number, holder, expiryDate, CVC);
        controller.payment(creditCard,cost);



        List<ItemsForInspections> inspectionList = controller.startInspections();
        for(int i = 0; i < inspectionList.size();i++ ){
            System.out.println("Part to inspect: " + inspectionList.get(i).getNameOfInspection());
            System.out.println("Enter result, Pass or Fail.");
            controller.saveResult(i, in.next());
        }
        controller.getResults();
        controller.initiateNewInspection();
    }


    /**
     *Takes care of all the exceptions so they will be printed and logged.
     *
     * @param msg The message of why there was an exceptioon
     * @param e the exception that occurred
     */
    private void exceptionHandler(String msg, Exception e){
        errorMsg.showErrorMsg(msg);
        log.logException(e);

    }

}
