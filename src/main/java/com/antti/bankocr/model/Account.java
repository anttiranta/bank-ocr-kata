package com.antti.bankocr.model;

/**
 * @author Antti Ranta
 */
public class Account {

    /**
     * ERR: wrong checksum
     * ILL: illegible number
     */
    public static enum ERROR {
        ERR, ILL
    }

    private String accountNumber;
    private Integer checksum; 
    private ERROR error = Account.ERROR.ILL;
    private boolean validated = false;

    public String getAccountNumber() {
        return accountNumber;
    }

    public Account setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public Integer getChecksum() {
        return checksum;
    }

    public Account setChecksum(Integer checksum) {
        this.checksum = checksum;
        return this;
    }

    public ERROR getError() {
        return error;
    }
    
    public Account setError(ERROR error){
        this.error = error;
        return this;
    }

    public boolean isValid() {
        return error == null && validated == true;
    }
    
    public Account markAsValidated(boolean validated){
        this.validated = validated;
        return this;
    }
}
