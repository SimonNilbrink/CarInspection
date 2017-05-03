package se.kth.iv1350.carInspection.model;

import se.kth.iv1350.carInspection.integration.DatabaseManager;
import se.kth.iv1350.carInspection.integration.ItemsForInspections;

import java.util.List;


public class Inspection {
    private Car car;
    private DatabaseManager dbManager;
    private List<ItemsForInspections> inspectionListToDo;


    public Inspection(DatabaseManager dbManager, Car car) {
        this.car = car;
        this.dbManager = dbManager;
        this.inspectionListToDo = dbManager.getInspections(car);
    }

    public int calculateCost () {
        int cost = 0;
        for (int i = 0; i < inspectionListToDo.size(); i++) {
            cost += inspectionListToDo.get(i).getPrice();
        }
        return cost;
    }


    public List<ItemsForInspections> getInspections(){
        return inspectionListToDo;
    }

}
