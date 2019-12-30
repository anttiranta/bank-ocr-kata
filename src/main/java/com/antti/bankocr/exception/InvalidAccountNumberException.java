package com.antti.bankocr.exception;

/**
 * @author Antti Ranta
 */
public class InvalidAccountNumberException extends Exception {
    
    public InvalidAccountNumberException() {
        super();
    }
    
    public InvalidAccountNumberException(String message){
        super(message);
    }
    
    public InvalidAccountNumberException(String message, Exception e){
        super(message, e);
    }
}
