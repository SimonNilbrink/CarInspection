package se.kth.iv1350.carInspection.model;

import se.kth.iv1350.carInspection.integration.DatabaseManager;
import se.kth.iv1350.carInspection.integration.ItemsForInspections;
import se.kth.iv1350.carInspection.integration.NotValidRegNoException;

import java.util.List;

/**
 * Represents where the total cost is being calculated and which item to inspect on a specific car.
 */
public class Inspection {
    private final Car car;
    private DatabaseManager dbManager;
    private List<ItemsForInspections> inspectionListToDo;

    /**
     * Constructor creates an instance of inspection representing inspections to be performed for specified car.
     *
     * @param dbManager Database manager used for all database calls.
     * @param car Car that is being inspected.
     */
    public Inspection(DatabaseManager dbManager, Car car) throws NotValidRegNoException{
        this.car = car;
        this.dbManager = dbManager;
        this.inspectionListToDo = dbManager.getInspections(car);
    }

    /**
     * Calculates the total cost for the inspection.
     *
     * @return Total cost.
     */
    public int calculateCost () {
        int cost = 0;
        for (int i = 0; i < inspectionListToDo.size(); i++) {
            cost += inspectionListToDo.get(i).getPrice();
        }
        return cost;
    }

    /**
     * @return Inspections to be performed.
     */
    public List<ItemsForInspections> getInspections(){
        return inspectionListToDo;
    }

}
