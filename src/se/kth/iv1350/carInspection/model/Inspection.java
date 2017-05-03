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

    public double calculateCost () {
        double cost = 0;
        for (int i = 0; i < inspectionListToDo.size(); i++) {
            cost += inspectionListToDo.get(i).getPrice();
        }
        return cost;
    }

    public void getNextInspection(){
        for (int i = 0; i < inspectionListToDo.size(); i++) {
            System.out.println("Part to inspect: " + inspectionListToDo.get(i).getNameOfInspection());
            saveResult(i);
        }

    }

    private void saveResult(int index){
        String passOrFail;
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println("Enter result, Pass or Fail.");
        passOrFail = in.next();
        dbManager.saveResultToDatabase(inspectionListToDo.get(index).getNameOfInspection(), passOrFail);
    }
}
