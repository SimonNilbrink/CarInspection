package se.kth.iv1350.carInspection.model;


import se.kth.iv1350.carInspection.integration.DatabaseManager;
import se.kth.iv1350.carInspection.integration.ItemsForInspections;
import se.kth.iv1350.carInspection.integration.Printer;


import java.util.List;

public class Result {
    private List<ItemsForInspections> resultList;



    public Result(DatabaseManager dbManager, Car car){
        this.resultList =  dbManager.getInspections(car);
    }


    public void printResult(){
        Printer.printResult(resultPrintOut());
    }


    public String resultPrintOut(){
        String printOut = "\n*****RESULT*****";
        for(int i = 0; i < resultList.size(); i++){
            printOut += "\n" + resultList.get(i).getNameOfInspection() +
                    " " + resultList.get(i).getResult();
        }
        return printOut + "\n**END OF RESULT**";
    }
}
