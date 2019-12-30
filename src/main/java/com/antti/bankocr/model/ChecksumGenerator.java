package com.antti.bankocr.model;

import com.antti.bankocr.model.validator.AccountNumberValidator;

/**
 * @author Antti Ranta
 */
public class ChecksumGenerator {

    private static final int MODULO = 11;
    
    public Integer generateFor(final String accountNumber) throws IllegalArgumentException {
        if (accountNumber == null 
                || !accountNumber.matches(AccountNumberValidator.VALID_ACCOUNT_NUMBER_REGEX)
        ) {
            throw new IllegalArgumentException(
                    "Could not generate checksum for account number: " + accountNumber
            );
        }
        
        int total = 0;
        int base = 1;
        
        char[] accountNumArrayReversed = new StringBuilder(accountNumber).reverse().toString()
                .toCharArray();
        
        for (char c : accountNumArrayReversed) {
            total += (c - '0') * base;
            base++;
        }

        return total % MODULO;
    }
}
