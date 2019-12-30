package com.antti.bankocr.model.account;

import com.antti.bankocr.model.Account;
import com.antti.bankocr.model.ChecksumGenerator;
import com.antti.bankocr.model.DigitsMapper;
import com.antti.bankocr.model.validator.AccountNumberValidator;
import com.antti.bankocr.model.validator.ChecksumValidator;

/**
 * @author Antti Ranta
 */
public class Builder {
    
    private final AccountNumberValidator validAccountNumberValidator;
    private final ChecksumValidator checksumValidator;
    private final ChecksumGenerator checksumGenerator;
    
    public Builder(
        AccountNumberValidator validAccountNumberValidator,
        ChecksumValidator checksumValidator,
        ChecksumGenerator checksumGenerator
    ){
        this.validAccountNumberValidator = validAccountNumberValidator;
        this.checksumValidator = checksumValidator;
        this.checksumGenerator = checksumGenerator;
    }
    
    public Account build(final String accountNumber) {
        Account account = null;
        
        if (accountNumber == null) {
            account = this.createInvalidAccount();
        } else if (!accountNumber.matches(AccountNumberValidator.ALLOWED_ACCOUNT_NUMBER_REGEX)) {
            account = this.createInvalidAccount();
        } else {
            account = (new Account())
                .setAccountNumber(accountNumber);
        }
        
        try {
            Integer checksum = this.checksumGenerator.generateFor(accountNumber);
            account.setChecksum(checksum);
        } catch(IllegalArgumentException iae) {
        }
        
        this.validate(account);
        return account;
    }
    
    protected void validate(Account account) {
        if (!this.validAccountNumberValidator.isValid(account.getAccountNumber())) {
            account.setError(Account.ERROR.ILL);
        } else if (!this.checksumValidator.isValid(account.getChecksum())) {
            account.setError(Account.ERROR.ERR);
        } else {
            account.setError(null);
        }
        
        account.markAsValidated(true);
    }
    
    private Account createInvalidAccount() {
        String invalidAccountNum = String.valueOf(
                DigitsMapper.ILLEGIBLE_OCR_DIGIT).repeat(
                        AccountNumberValidator.ACCOUNT_NUMBER_MAX_LENGTH
                );
        
        return (new Account())
                .setAccountNumber(invalidAccountNum);
    }
}
