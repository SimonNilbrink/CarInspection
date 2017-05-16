package se.kth.iv1350.carInspection.controller;

/**
 * OperationFailedException are thrown when there is an operation that has gone wrong
 * and the cause can be unknown.
 *
 */
public class OperationFailedException extends Exception {

    /**
     * Constructor creates a new instance representing the condition described in the specified messages.
     *
     * @param cause The cause of the excpetion
     * @param msg A massage for what went wrong.
     */
    public OperationFailedException(String msg,Exception cause) {
        super(msg,cause);
    }
}
