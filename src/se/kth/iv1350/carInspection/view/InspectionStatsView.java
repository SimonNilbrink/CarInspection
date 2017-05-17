package se.kth.iv1350.carInspection.view;

import se.kth.iv1350.carInspection.integration.ResultObserver;

/**
 *Keeps track of all the passed and failed inspections that has been done
 */
public class InspectionStatsView implements ResultObserver {

    int numberOfPassedInspections = 0;
    int numberOfFailedInspections = 0;
    public InspectionStatsView() {}


    /**
     * Counts the passed and failed inspections separately  and prints them to the screen
     *
     * @param resultOfInspection the specified result
     */
    @Override
    public void newResult(String resultOfInspection) {

        if (resultOfInspection.equals("Pass")) {
            numberOfPassedInspections++;
            System.out.println("---------------------------------"+
                    "\n"+"Number of passed inspections: "
                    + numberOfPassedInspections+"\n"+
                    "---------------------------------");
        }
        else if (resultOfInspection.equals("Fail")) {
            numberOfFailedInspections++;
            System.out.println("---------------------------------" +
                    "\n" + "Number of failed inspections: " +
                    numberOfFailedInspections + "\n" +
                    "---------------------------------");
        }
    }
}
