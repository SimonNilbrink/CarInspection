package se.kth.iv1350.carInspection.view;

import se.kth.iv1350.carInspection.controller.Controller;
import se.kth.iv1350.carInspection.model.CreditCard;

import java.time.YearMonth;

/**
 *
 */

public class View {
    private Controller controller;

    /**
     * Constructor for new instance that will use the specified contrller for all operations.
     *
     * @param controller Controller for system operations.
     */

    public View(Controller controller){
        this.controller = controller;
    }

    /**
     *
     */
    public void start () {
        controller.initiateNewInspection();


        String regNo = "ABS123";
        double cost = controller.checkForInspections(regNo);

        int pin = 1234;
        String number = "5461234";
        String holder = "Anders Andersson";
        YearMonth expiryDate = YearMonth.of(2018,2) ;
        
        int CVC = 456;
        CreditCard creditCard = new CreditCard(pin, number, holder, expiryDate, CVC);
        controller.payment(creditCard,cost);

        controller.nextInspection();


    }

}
