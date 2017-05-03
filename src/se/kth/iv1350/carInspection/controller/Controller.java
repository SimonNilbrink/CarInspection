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

/**
 * This is the Controller for the application. All calls to the model layer goes through here.
 */

public class Controller {


    private Garage garage;
    private DatabaseManager dbManager = new DatabaseManager();
    private Inspection inspection;
    private Car car;
    List<ItemsForInspections> inspectionsToDo;

    /**
     * Constructor that creates instance of controller.
     *
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

    /**
     * Verifies that there are inspections to be made
     * for a specific car and returns a cost for the inspections.
     *
     * @param regNo Registration number for the car that will be inspected.
     * @return The total cost of the Inspection.
     */

    public int checkForInspections(String regNo){
        car = new Car(regNo);
        inspection = new Inspection(dbManager, car);
        return inspection.calculateCost();

    }

    /**
     * Gets a list of the inspections to be performed.
     *
     * @return List of inspections.
     */
    public List<ItemsForInspections> startInspections(){
        inspectionsToDo = inspection.getInspections();
        return inspectionsToDo;
    }

    /**
     * Creates a object Result and calls it's printResult method.
     */

    public void getResults(){
        Result result = new Result(dbManager, car);
        result.printResult();

    }

    /**
     * Inspector gives result of inspected item. The result saves to the database.
     *
     * @param index Which inspected item that is performed.
     * @param passOrFail The result of the inspected item that is performed.
     */
    public void saveResult(int index, String passOrFail){
        dbManager.saveResultToDatabase(inspectionsToDo.get(index).getNameOfInspection(), passOrFail);
    }

    /**
     * Checks if payment can be authorized, with given credit card.
     *
     * @param creditCard Customer's credit card.
     * @param cost Total cost of inspection.
     */

    public void payment(CreditCard creditCard, int cost) {
        Payment.getPaymentAuthorization(creditCard,cost);
    }


}
