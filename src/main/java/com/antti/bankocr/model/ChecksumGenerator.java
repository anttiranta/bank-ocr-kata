package com.antti.bankocr.model;

import com.antti.bankocr.model.validator.AccountNumberValidator;

/**
 * @author Antti Ranta
 */
public class ChecksumGenerator {

    private static final int MODULO = 11;
    
    public Integer generateFor(final String accountNumber) throws IllegalArgumentException {
        if (!canGenerateFor(accountNumber)) {
            throw new IllegalArgumentException(
                    "Could not generate checksum for account number: " + accountNumber
            );
        }
        return generate(accountNumber);
    }
    
    private Integer generate(final String accountNumber) {
        int total = 0;
        int base = 1;
        
        char[] accountNumArrayReversed = new StringBuilder(accountNumber).reverse().toString()
                .toCharArray();
        
        for (char c : accountNumArrayReversed) {
            total += Character.getNumericValue(c) * base;
            base++;
        }

        return total % MODULO;
    }
    
    private boolean canGenerateFor(final String accountNumber) {
        return accountNumber != null 
                && accountNumber.matches(AccountNumberValidator.ACCOUNT_NUMBER_RGX);
    }
}
