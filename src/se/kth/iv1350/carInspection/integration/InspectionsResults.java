package se.kth.iv1350.carInspection.integration;

/**
 * Created by dinimac on 2017-05-02.
 */
public class InspectionsResults {

    private final String name;
    private final String result;

    /**
     *
     * @param name
     * @param result
     */
    public ItemsForInspections(String name, String result){
        this.name = name;
        this.result = result;

    }

    /**
     *
     */
    public getName(){
        return name;
    }

    /**
     *
     */
    public getResult(){
        return result;
    }
}
