package com.antti.bankocr.model.validator;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author Antti Ranta
 */
public class ChecksumValidatorTest {
    
    private ChecksumValidator checksumValidator;
    
    @Before
    public void setUp(){
        this.checksumValidator = new ChecksumValidator();
    }
    
    @Test
    public void testValidateInvalidChecksum() {
        assertFalse(this.checksumValidator.isValid(4));
    }
    
    @Test
    public void testValidateInvalidChecksum2() {
        assertFalse(this.checksumValidator.isValid(7));
    }
    
    @Test
    public void testValidateNullChecksum() {
        assertFalse(this.checksumValidator.isValid(null));
    }
    
    @Test
    public void testValidateWith0() {
        assertTrue(this.checksumValidator.isValid(0));
    }
}
