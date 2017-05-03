package se.kth.iv1350.carInspection.integration;

import se.kth.iv1350.carInspection.model.Receipt;

/**
 *  This is the printer that takes care of all printouts.
 */
public class Printer {


    /**
     * Represents a printout of the receipt with a print to output.
     *
     * @param receipt A object of type receipt with information about cost and card.
     */
     public static void printReceipt (Receipt receipt) {
         System.out.println(receipt.receiptPrintOut());
     }

    /**
     * Represents a printout of the result with a print to output.
     *
     * @param result Result represented in a string.
     */
    public static void printResult (String result) {System.out.println(result);}
}
