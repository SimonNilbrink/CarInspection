package se.kth.iv1350.carInspection.model;

import se.kth.iv1350.carInspection.integration.DatabaseManager;
import se.kth.iv1350.carInspection.integration.ItemsForInspections;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by dinimac on 2017-05-02.
 */
public class Inspection {
    private Car car;
    private DatabaseManager dbMan;


    public Inspection(DatabaseManager dbMan, Car car) {
        this.car = car;
        this.dbMan = dbMan;
    }

    public double calculateCost () {
        List<ItemsForInspections> inspectionList = dbMan.getInspections(car);
        double cost = 0;
        for (int i = 0; i < inspectionList.size(); i++) {
            cost += inspectionList(i);
        }
        return cost;
    }
}
