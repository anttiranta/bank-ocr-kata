package com.antti.bankocr.model;

import com.antti.bankocr.model.validator.AccountNumberValidator;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author Antti Ranta
 */
public class ChecksumGeneratorTest {
    
    private static final String DEFAULT_ERROR_MESSAGE = "Invalid checksum.";
    
    private ChecksumGenerator checksumGenerator;
    
    @Before
    public void setUp(){
        this.checksumGenerator = new ChecksumGenerator();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGenerateForInvalidAccountNumber0() {
        String accountNumber = "0";
        checksumGenerator.generateFor(accountNumber);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGenerateForInvalidAccountNumber1() {
        String accountNumber = "1";
        checksumGenerator.generateFor(accountNumber);
    }
    
    @Test
    public void testGenerateFor000000000() {
        String accountNumber = "0".repeat(AccountNumberValidator.ACCOUNT_NUMBER_MAX_LENGTH);
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                0,
                (long)checksumGenerator.generateFor(accountNumber)
        );
    }
    
    @Test
    public void testGenerateForInvalidAccountNumber111111111() {
        String accountNumber = "1".repeat(AccountNumberValidator.ACCOUNT_NUMBER_MAX_LENGTH);
        assertNotEquals(
                DEFAULT_ERROR_MESSAGE,
                0,
                (long)checksumGenerator.generateFor(accountNumber)
        );
    }
    
    @Test
    public void testGenerateForInvalidAccountNumber222222222() {
        String accountNumber = "2".repeat(AccountNumberValidator.ACCOUNT_NUMBER_MAX_LENGTH);
        assertNotEquals(
                DEFAULT_ERROR_MESSAGE,
                0,
                (long)checksumGenerator.generateFor(accountNumber)
        );
    }
    
    @Test
    public void testGenerateForInvalidAccountNumber777777777() {
        String accountNumber = "7".repeat(AccountNumberValidator.ACCOUNT_NUMBER_MAX_LENGTH);
        assertNotEquals(
                DEFAULT_ERROR_MESSAGE,
                0,
                (long)checksumGenerator.generateFor(accountNumber)
        );
    }
    
    @Test
    public void testGenerateForInvalidAccountNumber888888888() {
        String accountNumber = "8".repeat(AccountNumberValidator.ACCOUNT_NUMBER_MAX_LENGTH);
        assertNotEquals(
                DEFAULT_ERROR_MESSAGE,
                0,
                (long)checksumGenerator.generateFor(accountNumber)
        );
    }
    
    @Test
    public void testGenerateForInvalidAccountNumber9999999999() {
        String accountNumber = "9".repeat(AccountNumberValidator.ACCOUNT_NUMBER_MAX_LENGTH);
        assertNotEquals(
                DEFAULT_ERROR_MESSAGE,
                0,
                (long)checksumGenerator.generateFor(accountNumber)
        );
    }
    
    @Test
    public void testGenerateFor123456789() {
        String accountNumber = "123456789";
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                0,
                (long)checksumGenerator.generateFor(accountNumber)
        );
    }
    
    @Test
    public void testGenerateFor000000051() {
        String accountNumber = "000000051";
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                0,
                (long)checksumGenerator.generateFor(accountNumber)
        );
    }
    
    @Test
    public void testGenerateForInvalidAccountNumber110101100() {
        String accountNumber = "110101100";
        assertNotEquals(
                DEFAULT_ERROR_MESSAGE,
                0,
                (long)checksumGenerator.generateFor(accountNumber)
        );
    }
    
    @Test
    public void testGenerateForInvalidAccountNumber490067715() {
        String accountNumber = "490067715";
        assertNotEquals(
                DEFAULT_ERROR_MESSAGE,
                0,
                (long)checksumGenerator.generateFor(accountNumber)
        );
    }
    
    @Test
    public void testGenerateFor490867715() {
        String accountNumber = "490867715";
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                0,
                (long)checksumGenerator.generateFor(accountNumber)
        );
    }
    
    @Test
    public void testGenerateFor457508000() {
        String accountNumber = "457508000";
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                0,
                (long)checksumGenerator.generateFor(accountNumber)
        );
    }
    
    @Test
    public void testGenerateFor711111111() {
        String accountNumber = "711111111";
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                0,
                (long)checksumGenerator.generateFor(accountNumber)
        );
    }
    
    @Test
    public void testGenerateFor345882865() {
        String accountNumber = "345882865";
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                0,
                (long)checksumGenerator.generateFor(accountNumber)
        );
    }
    
    @Test
    public void testGenerateForInvalidAccountNumber664371495 () {
        String accountNumber = "664371495";
        assertNotEquals(
                DEFAULT_ERROR_MESSAGE,
                0,
                (long)checksumGenerator.generateFor(accountNumber)
        );
    }
    
    @Test
    public void testGenerateForInvalidAccountNumber012345678 () {
        String accountNumber = "012345678";
        assertNotEquals(
                DEFAULT_ERROR_MESSAGE,
                0,
                (long)checksumGenerator.generateFor(accountNumber)
        );
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGenerateForMalformedAccountNumber () {
        String accountNumber = "1" 
                + DigitsMapper.ILLEGIBLE_OCR_DIGIT 
                + DigitsMapper.ILLEGIBLE_OCR_DIGIT 
                + "4"
                + DigitsMapper.ILLEGIBLE_OCR_DIGIT
                + "6"
                + DigitsMapper.ILLEGIBLE_OCR_DIGIT
                + "09";
        checksumGenerator.generateFor(accountNumber);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGenerateForMalformedAccountNumber2 () {
        String accountNumber = "1234" 
                + DigitsMapper.ILLEGIBLE_OCR_DIGIT 
                + "678"
                + DigitsMapper.ILLEGIBLE_OCR_DIGIT;
        checksumGenerator.generateFor(accountNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateForMalformedAccountNumber3 () {
        String accountNumber = "86110" 
                + DigitsMapper.ILLEGIBLE_OCR_DIGIT 
                + DigitsMapper.ILLEGIBLE_OCR_DIGIT 
                + "36";
        checksumGenerator.generateFor(accountNumber);
    }
}
