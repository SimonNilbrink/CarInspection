package se.kth.iv1350.carInspection.startup;

import se.kth.iv1350.carInspection.model.garage.Garage;
import se.kth.iv1350.carInspection.controller.Controller;
import se.kth.iv1350.carInspection.view.View;

import java.io.IOException;

/**
 * Starts the application.
 */

public class Main {
    /**
     * This is the application's main method, starts the entire car inspection system.
     *
     * @param args The are no command line parameters.
     * @throws IOException if the application couldn't start for some reason.
     */
    public static void main(String[] args) {
        try {
            Garage garage = new Garage();
            Controller controller = new Controller(garage);
            View view = new View(controller);
            view.start();
        }catch (IOException e){
            System.out.println("Couldnt start application");
        }

    }
}
