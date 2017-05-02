package se.kth.iv1350.carInspection.controller;

import se.kth.iv1350.carInspection.integration.DatabaseManager;
import se.kth.iv1350.carInspection.model.Car;
import se.kth.iv1350.carInspection.model.Inspection;
import se.kth.iv1350.carInspection.model.garage.Garage;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by dinimac on 2017-05-02.
 */
public class Controller {

    private Garage garage;
    private DatabaseManager dbManager = new DatabaseManager();


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



    public double checkForInspections(String regNo){
        Car car = new Car(regNo);
        Inspection inspection = new Inspection(dbManager, car);
        return inspection.calculateCost();

    }


}
