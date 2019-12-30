package com.antti.bankocr.model.validator;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author Antti Ranta
 */
public class AccountNumberValidatorTest {
    
    private AccountNumberValidator accountNumberValidator;
    
    @Before
    public void setUp(){
        this.accountNumberValidator = new AccountNumberValidator();
    }
    
    @Test
    public void testValidateIllegibleAccountNumber() {
        assertFalse(this.accountNumberValidator.isValid("49006771?"));
    }
    
    @Test
    public void testValidateIllegibleAccountNumber2() {
        assertFalse(this.accountNumberValidator.isValid("1234?678?"));
    }
    
    @Test
    public void testValidateNullAccountNumber() {
        assertFalse(this.accountNumberValidator.isValid(null));
    }
    
    @Test
    public void testValidateWithInvalidAccountNumber() {
        assertFalse(this.accountNumberValidator.isValid("test"));
    }
    
    @Test
    public void testValidateWithInvalidAccountNumber2() {
        assertFalse(this.accountNumberValidator.isValid("1AE4F6C09"));
    }
    
    @Test
    public void testValidateWithEmptyAccountNumber() {
        assertFalse(this.accountNumberValidator.isValid(""));
    }
}
