package se.kth.iv1350.carInspection.model;

import se.kth.iv1350.carInspection.integration.DatabaseManager;
import se.kth.iv1350.carInspection.integration.ItemsForInspections;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class Inspection {
    private Car car;
    private DatabaseManager dbManager;
    private List<ItemsForInspections> inspectionListToDo;


    public Inspection(DatabaseManager dbManager, Car car) {
        this.car = car;
        this.dbManager = dbManager;
        this.inspectionListToDo = dbManager.getInspections(car);
    }

    public double calculateCost () {
        double cost = 0;
        for (int i = 0; i < inspectionListToDo.size(); i++) {
            cost += inspectionListToDo.get(i).getPrice();
        }
        return cost;
    }

    public void getNextInspection(){
        java.util.Scanner in = new java.util.Scanner(System.in);
        String passOrFail;
        for (int i = 0; i < inspectionListToDo.size(); i++) {
            System.out.println(inspectionListToDo.get(i).getNameOfInspection());
            passOrFail = in.next();
            dbManager.saveResult(inspectionListToDo.get(i).getNameOfInspection(), passOrFail);
        }



    }
}
