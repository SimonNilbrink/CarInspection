package se.kth.iv1350.carInspection.integration;


public class ItemsForInspections{

    private final String name;
    private final int price;
    private final String result;

    /**
     *
     * @param name The name of inspection items
     * @param price The price of inspection item
     */
    ItemsForInspections(String name, int price, String result){
        this.name = name;
        this.price = price;
        this.result = result;
    }



    public int getPrice() {
        return price;
    }

    public String getNameOfInspection(){ return name;}

    String getResult(){
        return result;
    }

}


