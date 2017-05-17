package se.kth.iv1350.carInspection.integration;



public class NotValidRegNoException extends Exception{
    /**
     * Constructor creates a new instance representing the condition described in the specified messages.
     *
     * @param msg A massage for what went wrong.
     */
    public NotValidRegNoException(String msg){
        super(msg);
    }
}
