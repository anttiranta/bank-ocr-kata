package com.antti.bankocr.exception;

/**
 * @author Antti Ranta
 */
public class LogicException extends RuntimeException {
    
    public LogicException(String message){
        super(message);
    }
    
    public LogicException(String message, Exception e){
        super(message, e);
    }
}
