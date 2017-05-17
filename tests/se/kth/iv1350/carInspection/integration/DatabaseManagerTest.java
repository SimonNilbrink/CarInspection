package se.kth.iv1350.carInspection.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.carInspection.model.Car;
import se.kth.iv1350.carInspection.view.InspectionStatsView;

import java.util.List;

import static org.junit.Assert.*;

public class DatabaseManagerTest {
    Car tempCar;
    DatabaseManager tempDB;

    @Before
    public void setUp() throws Exception {
        tempCar = new Car("ABS123");
        tempDB = new DatabaseManager();

    }


    @After
    public void tearDown() throws Exception {
        tempCar = null;
        tempDB = null;
    }

    @Test
    public void testNumberOfExpectedInspections() {
        int expectedResult = 3;
        int result = tempDB.getInspections().size();
        assertEquals("Expected number of inspections wrong", expectedResult, result);
    }

    @Test
    public void testSavingInspectionsResultToDatabase(){
        String testName = "Wheels";
        String testResult = "Fail";
        tempDB.saveResultToDatabase(testName, testResult);
        List<ItemsForInspections> testList = tempDB.getInspections();
        String expectedResult = "WheelsGearboxLightsEngine";
        String result = "";
        for(int i = 0; i < testList.size(); i++)
            result += testList.get(i).getNameOfInspection();
        assertTrue("Wrong inspections in list", result.contains(expectedResult));
        assertFalse("Break should not be present", result.contains("Breaks"));
    }

}