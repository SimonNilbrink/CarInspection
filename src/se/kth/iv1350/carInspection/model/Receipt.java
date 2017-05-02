package se.kth.iv1350.carInspection.model;


public class Receipt {
    private double cost;
    private String cardNumber;

    public Receipt(double cost, CreditCard creditCard){
        this.cost = cost;
        this.cardNumber = creditCard.getNumber();
    }

    public String receiptPrintOut(){
        return cost + " was credited on card: " + cardNumber;
    }
}
