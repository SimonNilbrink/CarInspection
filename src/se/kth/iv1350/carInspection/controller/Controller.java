package se.kth.iv1350.carInspection.controller;

import se.kth.iv1350.carInspection.integration.DatabaseManager;
import se.kth.iv1350.carInspection.integration.ItemsForInspections;
import se.kth.iv1350.carInspection.model.Car;
import se.kth.iv1350.carInspection.model.CreditCard;
import se.kth.iv1350.carInspection.model.Inspection;
import se.kth.iv1350.carInspection.model.Result;
import se.kth.iv1350.carInspection.model.garage.Garage;
import se.kth.iv1350.carInspection.integration.Payment;

import java.util.List;


public class Controller {


    private Garage garage;
    private DatabaseManager dbManager = new DatabaseManager();
    private Inspection inspection;
    private Car car;
    List<ItemsForInspections> inspectionsToDo;

    /**
     * @param garage Specific garage for inspections.
     */

    public Controller(Garage garage){
        this.garage = garage;
    }

    /**
     * Opens the door, displays next que number and closes the door.
     *
     */

    public void initiateNewInspection () {
        garage.nextCustomer();
        garage.closeDoor();
    }


    public int checkForInspections(String regNo){
        car = new Car(regNo);
        inspection = new Inspection(dbManager, car);
        return inspection.calculateCost();

    }

    public List<ItemsForInspections> startInspections(){
        inspectionsToDo = inspection.getInspections();
        return inspectionsToDo;
    }


    public void getResults(){
        Result result = new Result(dbManager, car);
        result.printResult();

    }

    public void saveResult(int index, String passOrFail){
        dbManager.saveResultToDatabase(inspectionsToDo.get(index).getNameOfInspection(), passOrFail);
    }


    public void payment(CreditCard creditCard, int cost) {
        Payment.getPaymentAuthorization(creditCard,cost);
    }


}
