package se.kth.iv1350.carInspection.controller;

import se.kth.iv1350.carInspection.integration.*;
import se.kth.iv1350.carInspection.model.Car;
import se.kth.iv1350.carInspection.model.CreditCard;
import se.kth.iv1350.carInspection.model.Inspection;
import se.kth.iv1350.carInspection.model.Result;
import se.kth.iv1350.carInspection.model.garage.Garage;

import java.util.List;

/**
 * This is the Controller for the application. All calls to the model layer goes through here.
 */

public class Controller {

    private Garage garage;
    private DatabaseManager dbManager;
    private Inspection inspection;
    private Car car;
    List<ItemsForInspections> inspectionsToDo;

    /**
     * Constructor that creates instance of controller.
     *
     * @param garage Specific garage for inspections.
     */

    public Controller(Garage garage, ResultObserver observer){
        this.garage = garage;
        this.dbManager = new DatabaseManager();
        this.dbManager.addObserver(observer);

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
     * Checks if entered registration number are valid and has inspections.
     *
     * @param regNo the entered registration number
     * @throws OperationFailedException is thrown if the check valid reg number fails.
     */
    public void checkValidRegNo(String regNo) throws OperationFailedException{
        try{
            car = new Car(regNo);
            dbManager.checksValidRegNo(car);
        } catch (NotValidRegNoException e) {
            throw new OperationFailedException("Not valid registration number", e);
        }
    }


    /**
     * Verifies that there are inspections to be made
     * for a specific car and returns a cost for the inspections.
     *
     *
     * @return The total cost of the Inspection.
     */

    public int checkForInspections(){
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
        Result result = new Result(dbManager);
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
