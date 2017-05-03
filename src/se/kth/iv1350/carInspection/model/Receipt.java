package se.kth.iv1350.carInspection.model;


public class Receipt {
    private double cost;
    private String cardNumber;

    public Receipt(int cost, CreditCard creditCard){
        this.cost = cost;
        this.cardNumber = creditCard.getNumber();
    }

    public String receiptPrintOut(){
        return
                "\n*****RECEIPT*****" +
                "\nTotal cost: " + cost +
                "\nCredit Card: " + cardNumber +
                "\n**END OF RECEIPT**\n";
    }
}
