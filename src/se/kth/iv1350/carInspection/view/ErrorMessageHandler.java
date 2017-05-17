package se.kth.iv1350.carInspection.view;
import java.util.Date;

/**
 * Shows error messages
 */
public class ErrorMessageHandler {

    /**
     * This method takes care of formatting and printing the error message
     * to the user.
     *
     * @param msg The message of why there was an exceptioon
     */
    public void showErrorMsg(String msg){
        Date date = new Date();
        System.out.println(date + ", Error: " + msg);
    }
}
