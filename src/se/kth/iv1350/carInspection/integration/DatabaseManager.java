package se.kth.iv1350.carInspection.integration;

import java.util.List;
import java.util.ArrayList;
import se.kth.iv1350.carInspection.model.Car;

/**
 *
 */
public class DatabaseManager {

    private List<ItemsForInspections> inspectionList;
    //private List<InspectionsResults> resultList;


    /**
     *
     */
    public DatabaseManager() {
        createInspectionList();
        //createResultList();
    }



    public List<ItemsForInspections> getInspections(Car car){
        List<ItemsForInspections> inspectionsToDo = new ArrayList<>();
        if(car.getRegNo().equals("ABS123")) {

            for (int i = 0; i < 5; i++) {
                if (inspectionList.get(i).getResult().equals("Fail"))
                    inspectionsToDo.add(inspectionList.get(i));
            }
        }
        return inspectionsToDo;

    }


    /**
     * Creates a list to represent a real database.
     */

    private void createInspectionList() {
        inspectionList = new ArrayList<>();
        inspectionList.add(new ItemsForInspections("Wheels", 100, "Fail"));
        inspectionList.add(new ItemsForInspections("Gearbox", 150, "Fail"));
        inspectionList.add(new ItemsForInspections("Lights", 50, "Fail"));
        inspectionList.add(new ItemsForInspections("Breaks", 100, "Fail"));
        inspectionList.add(new ItemsForInspections("Engine", 200, "Fail"));
    }


    public void saveResult(String nameOfInspection, String resultOfInspection){
        for (int i = 0; i < 5; i++) {
            if (nameOfInspection.equals(inspectionList.get(i).getNameOfInspection())){
                inspectionList.set(i, new ItemsForInspections(inspectionList.get(i).getNameOfInspection(), inspectionList.get(i).getPrice(), resultOfInspection));
            }
        }
    }



//
//     public void createResultList(){
//        resultList = new ArrayList<>();
//        resultList.add(new InspectionsResults("Wheels", "Fail"));
//        resultList.add(new InspectionsResults("Gearbox", "Fail"));
//        resultList.add(new InspectionsResults("Lights", "Fail"));
//        resultList.add(new InspectionsResults("Breaks", "Fail"));
//        resultList.add(new InspectionsResults("Engine", "Fail"));
//
//    }
    //




}

