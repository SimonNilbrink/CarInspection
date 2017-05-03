package se.kth.iv1350.carInspection.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.carInspection.integration.DatabaseManager;
import se.kth.iv1350.carInspection.integration.ItemsForInspections;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dinimac on 2017-05-03.
 */
public class InspectionTest {
    Car tempCar;
    DatabaseManager tempDB;
    Inspection tempInspect;

    @Before
    public void setUp() throws Exception {
        tempCar = new Car("ABS123");
        tempDB = new DatabaseManager();
        tempInspect = new Inspection(tempDB, tempCar);


    }

    @After
    public void tearDown() throws Exception {
        tempCar = null;
        tempDB = null;
        tempInspect = null;

    }


    @Test
    public void testCalculatedCost(){
        int expextedCost = 400;
        int cost = tempInspect.calculateCost();
        assertEquals("Expected cost wrong", expextedCost, cost);
    }

    @Test
    public void testNumberOfExpectedInspections() {
        int expectedResult = 3;
        int result = tempDB.getInspections(tempCar).size();
        assertEquals("Expected number of inspections wrong", expectedResult, result);
    }

    @Test
    public void testIfCorrectInspectionsToDo(){
        List<ItemsForInspections> testList = tempInspect.getInspections();
        String expectedResult = "GearboxLightsEngine";
        String result = "";
        for(int i = 0; i < testList.size(); i++)
            result += testList.get(i).getNameOfInspection();
        assertTrue("Wrong inspections in list", result.contains(expectedResult));
    }
}