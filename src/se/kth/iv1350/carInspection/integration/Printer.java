package se.kth.iv1350.carInspection.integration;

import se.kth.iv1350.carInspection.model.Receipt;

/**
 *
 */
public class Printer {



     public static void printReceipt (Receipt receipt) {
         System.out.println(receipt.receiptPrintOut());
     }



    public static void printResult (String printOut) {System.out.println(printOut);}
}
