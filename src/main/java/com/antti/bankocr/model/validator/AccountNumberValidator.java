package com.antti.bankocr.model.validator;

/**
 * @author Antti Ranta
 */
public class AccountNumberValidator {

    public static final int ACCOUNT_NUMBER_MAX_LENGTH = 9;
    public static final String VALID_ACCOUNT_NUMBER_REGEX = "\\d{" + ACCOUNT_NUMBER_MAX_LENGTH + "}";
    public static final String ALLOWED_ACCOUNT_NUMBER_REGEX = "[\\d\\?]{" + ACCOUNT_NUMBER_MAX_LENGTH + "}"; 
    
    public boolean isValid(final String accountNumber) {
        if (accountNumber == null || !accountNumber.matches(VALID_ACCOUNT_NUMBER_REGEX)) {
            return false;
	}
        return true;
    }
}
