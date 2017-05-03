package se.kth.iv1350.carInspection.integration;

import se.kth.iv1350.carInspection.model.CreditCard;
import se.kth.iv1350.carInspection.model.Receipt;




public class Payment {


    /**
     *
     * @param creditCard
     * @param cost
     */
    public static void getPaymentAuthorization (CreditCard creditCard, int cost) {
        if (PaymentAuthorization.authorizePayment(creditCard,cost))
            printReceipt(cost, creditCard);
        else
            return;
    }


    /**
     *
     * @param cost
     * @param creditCard
     */
    public static void printReceipt(int cost, CreditCard creditCard){
        Receipt receipt = new Receipt(cost, creditCard);
        Printer.printReceipt(receipt);

    }

}
