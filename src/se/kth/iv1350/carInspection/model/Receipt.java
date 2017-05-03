package se.kth.iv1350.carInspection.model;

/**
 * Represents the receipt of the payment.
 */
public class Receipt {
    private double cost;
    private String cardNumber;

    /**
     * Constructor creates an instance of a receipt.
     *
     * @param cost Total cost of inspection.
     * @param creditCard Credit card that is being used to pay for inspection.
     */
    public Receipt(int cost, CreditCard creditCard){
        this.cost = cost;
        this.cardNumber = creditCard.getNumber();
    }

    /**
     * Format of the receipt.
     *
     * @return String that represents a receipt that will be printed.
     */
    public String receiptPrintOut(){
        return
                "\n*****RECEIPT*****" +
                "\nTotal cost: " + cost +
                "\nCredit Card: " + cardNumber +
                "\n**END OF RECEIPT**\n";
    }
}
