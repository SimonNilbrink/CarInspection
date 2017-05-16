package se.kth.iv1350.carInspection.model;


import se.kth.iv1350.carInspection.integration.DatabaseManager;
import se.kth.iv1350.carInspection.integration.ItemsForInspections;
import se.kth.iv1350.carInspection.integration.NotValidRegNoException;
import se.kth.iv1350.carInspection.integration.Printer;
import java.util.List;

/**
 * Represents the result from the performed inspection.
 */
public class Result {
    private List<ItemsForInspections> resultList;


    /**
     * Constructor creates an instance of result representing the result from performed inspection.
     *
     * @param dbManager Database manager used for all database calls.
     */
    public Result(DatabaseManager dbManager){
        this.resultList = dbManager.getInspections();
    }

    /**
     * Send the formatted result to printer for printout.
     */
    public void printResult(){
        Printer.printResult(resultPrintOut());
    }

    /**
     * Formatting the result to a printable string.
     *
     * @return String representing the result.
     */
    public String resultPrintOut(){
        String printOut = "\n*****RESULT*****";
        for(int i = 0; i < resultList.size(); i++){
            printOut += "\n" + resultList.get(i).getNameOfInspection() +
                    " " + resultList.get(i).getResult();
        }
        return printOut + "\n**END OF RESULT**";
    }
}
