package com.antti.bankocr.model.validator;

/**
 * @author Antti Ranta
 */
public class AccountNumberValidator {

    public static final int ACCOUNT_NUMBER_MAX_LENGTH = 9;
    public static final String ACCOUNT_NUMBER_RGX = "\\d{" + ACCOUNT_NUMBER_MAX_LENGTH + "}";
    public static final String ALLOWED_NUMBERS_RGX = "[\\d\\?]{" + ACCOUNT_NUMBER_MAX_LENGTH + "}"; 
    
    public boolean isValid(final String accountNumber) {
        if (accountNumber == null || !accountNumber.matches(ACCOUNT_NUMBER_RGX)) {
            return false;
	}
        return true;
    }
}
