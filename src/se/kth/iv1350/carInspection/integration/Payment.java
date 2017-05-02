package se.kth.iv1350.carInspection.integration;

import se.kth.iv1350.carInspection.model.CreditCard;
import se.kth.iv1350.carInspection.model.Receipt;




public class Payment {
    Printer printer = new Printer();

    /**
     *
     * @param creditCard
     * @param cost
     */
    public static void getPaymentAuthorization (CreditCard creditCard, double cost) {
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
    public void printReceipt(double cost, CreditCard creditCard){
        Receipt receipt = new Receipt(cost, creditCard);
        printer.printReceipt(receipt);

    }

}
