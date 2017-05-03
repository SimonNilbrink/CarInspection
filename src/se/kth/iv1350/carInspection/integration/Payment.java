package se.kth.iv1350.carInspection.integration;

import se.kth.iv1350.carInspection.model.CreditCard;
import se.kth.iv1350.carInspection.model.Receipt;


/**
 * Takes care of calls to payment authorization and the printer.
 */

public class Payment {


    /**
     * Gets proof that payment been done from external system
     *
     * @param creditCard The credit card that was used for the payment of the inspection.
     * @param cost Total cost of the inspection.
     */
    public static void getPaymentAuthorization (CreditCard creditCard, int cost) {
        if (PaymentAuthorization.authorizePayment(creditCard,cost))
            printReceipt(cost, creditCard);
        else
            return;
    }


    /**
     * Sends an instance of receipt object to the printer.
     *
     * @param cost Total cost of the inspection.
     * @param creditCard The credit card that was used for the payment of the inspection.
     */
    public static void printReceipt(int cost, CreditCard creditCard){
        Receipt receipt = new Receipt(cost, creditCard);
        Printer.printReceipt(receipt);

    }

}
