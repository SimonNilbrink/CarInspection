package se.kth.iv1350.carInspection.controller;

/**
 * OperationFailedException are thrown when there is an operation that has gone wrong
 * and the cause can be unknown.
 *
 */
public class OperationFailedException extends Exception {

    public OperationFailedException(String msg,Exception cause){super(msg,cause);}
}
