package se.kth.iv1350.carInspection.integration;

/**
 * Represents a specific inspection item.
 */
public class ItemsForInspections{

    private final String name;
    private final int price;
    private final String result;

    /**
     * Constructor that creates an instance of a inspection item.
     *
     * @param name The name of inspection items.
     * @param price The price of inspection item.
     * @param result The result of inspection item.
     */
    ItemsForInspections(String name, int price, String result){
        this.name = name;
        this.price = price;
        this.result = result;
    }

    /**
     * @return Price of the inspection item.
     */

    public int getPrice() {
        return price;
    }

    /**
     * @return Name of the inspection item.
     */
    public String getNameOfInspection(){ return name;}

    /**
     * @return Result of the inspection item.
     */
    public String getResult(){
        return result;
    }

}


