package se.kth.iv1350.carInspection.integration;

import java.util.List;
import java.util.ArrayList;
import se.kth.iv1350.carInspection.model.Car;

/**
 *
 */
public class DatabaseManager {

    private List<ItemsForInspections> inspectionList;
    private List<InspectionsResults> resultList;


    /**
     *
     */
    public DatabaseManager() {
        createInspectionList();
        createResultList();
    }


    /**
     * Looks after inspections with fail and returns a list with inspections to do.
     *
     * @param car
     * @return
     */
    public List<ItemsForInspections> getInspections(Car car){
        List<ItemsForInspections> inspectionsToDo = new ArrayList<>();
        if(car.getRegNo().equals("ABS123")) {

            for (int i = 0; i < 5; i++)
                if (resultList(i).getResult().equals("Fail"))
                    inspectionsToDo.add(inspectionList(i));
        }
        return inspectionsToDo;

    }


    /**
     * Creates a list to represent a real database.
     */

    private void createInspectionList() {
        inspectionList = new ArrayList<>();
        inspectionList.add(new ItemsForInspections("Wheels", 100));
        inspectionList.add(new ItemsForInspections("Gearbox", 150));
        inspectionList.add(new ItemsForInspections("Lights", 50));
        inspectionList.add(new ItemsForInspections("Breaks", 100));
        inspectionList.add(new ItemsForInspections("Engine", 200));
    }

    private void createResultList(){
        resultList = new ArrayList<>();
        resultList.add(new InspectionsResults("Wheels", "Fail"));
        resultList.add(new InspectionsResults("Gearbox", "Fail"));
        resultList.add(new InspectionsResults("Lights", "Fail"));
        resultList.add(new InspectionsResults("Breaks", "Fail"));
        resultList.add(new InspectionsResults("Engine", "Fail"));

    }



}

