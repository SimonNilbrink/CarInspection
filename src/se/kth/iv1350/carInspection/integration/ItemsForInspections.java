package se.kth.iv1350.carInspection.integration;

/**
 * Created by dinimac on 2017-05-02.
 */
public class ItemsForInspections{

    private final String name;
    private final int price;

    /**
     *
     * @param name
     * @param price
     */
    public ItemsForInspections(String name, int price){
        this.name = name;
        this.price = price;

    }


    /**
     *
     * @return
     */

    public int getPrice() {
        return price;
    }
}


