package se.kth.iv1350.carInspection.integration;

import java.util.List;
import java.util.ArrayList;
import se.kth.iv1350.carInspection.model.Car;

/**
 * All calls for database goes through here. No other layer can call database.
 */
public class DatabaseManager {

    private List<ItemsForInspections> inspectionList;
    private List<ItemsForInspections> inspectionsToDo;


    /**
     * Creates a new instance with a dummy "database".
     */
    public DatabaseManager() {
        createInspectionList();
    }


    /**
     * Takes all the failed inspections and creates a new list for inspector to perform.
     *
     * @return List of inspections for the car that is being inspected.
     */
    public List<ItemsForInspections> getInspections(){
        inspectionsToDo = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (inspectionList.get(i).getResult().equals("Fail"))
                inspectionsToDo.add(inspectionList.get(i));
        }

        return inspectionsToDo;
    }

    /**
     * Checks if entered reg number are valid and has inspections.
     *
     * @param car
     * @throws NotValidRegNoException are thrown if the registration number are not valid or has no inspections
     */
    public void checksValidRegNo(Car car) throws NotValidRegNoException{
        if (!(car.getRegNo().equals("ABS123")))
            throw new NotValidRegNoException("Not valid registration number");

    }
    /**
     * Creates a list to represent a real database.
     */

    private void createInspectionList() {
        inspectionList = new ArrayList<>();
        inspectionList.add(new ItemsForInspections("Wheels", 100, "Pass"));
        inspectionList.add(new ItemsForInspections("Gearbox", 150, "Fail"));
        inspectionList.add(new ItemsForInspections("Lights", 50, "Fail"));
        inspectionList.add(new ItemsForInspections("Breaks", 100, "Pass"));
        inspectionList.add(new ItemsForInspections("Engine", 200, "Fail"));
    }

    /**
     * Saves the result from each inspection to database.
     *
     * @param nameOfInspection A specific inspection item.
     * @param resultOfInspection The result of the specific inspection item.
     */
    public void saveResultToDatabase(String nameOfInspection, String resultOfInspection){
        for (int i = 0; i < 5; i++) {
            if (nameOfInspection.equals(inspectionList.get(i).getNameOfInspection())){
                inspectionList.set(i, new ItemsForInspections(inspectionList.get(i).getNameOfInspection(),
                        inspectionList.get(i).getPrice(), resultOfInspection));
            }
        }
    }
}

