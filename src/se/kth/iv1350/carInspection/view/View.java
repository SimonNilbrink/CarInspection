package se.kth.iv1350.carInspection.view;

import se.kth.iv1350.carInspection.controller.Controller;

/**
 * Created by dinimac on 2017-05-02.
 */

public class View {
    private Controller controller;

    /**
     * Constructor for new instance that will use the specified contrller for all operations.
     *
     * @param controller Controller for system operations.
     */

    public View(Controller controller){
        this.controller = controller;
    }

    /**
     *
     */
    public void start () {
        controller.initiateNewInspection();


        String regNo = "ABS123";
        controller.checkForInspections(regNo);

    }

}
