package com.antti.bankocr.model.validator;

/**
 * @author Antti Ranta
 */
public class ChecksumValidator {
    
    public boolean isValid(final Integer checksum) {
        if (checksum == null || checksum != 0) {
            return false;
	}
        return true;
    }
}
