package se.kth.iv1350.carInspection.integration;

import se.kth.iv1350.carInspection.model.Receipt;

/**
 *
 */
public class Printer {

    /**
     *
     */
    public Printer () {
    }

     void printReceipt (Receipt receipt) {
        System.out.println(receipt.receiptPrintOut());
    }


    //public void printResult (Result result) {System.out.println(result.resultPrintOut())}
}
