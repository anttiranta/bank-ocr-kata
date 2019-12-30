package com.antti.bankocr.exception;

/**
 * @author Antti Ranta
 */
public class AccountNumberParseException extends Exception {
    
    public AccountNumberParseException() {
        super();
    }
    
    public AccountNumberParseException(String message){
        super(message);
    }
    
    public AccountNumberParseException(String message, Exception e){
        super(message, e);
    }
}
