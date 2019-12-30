package com.antti.bankocr.model.account.export;

import com.antti.bankocr.model.Account;

/**
 * @author Antti Ranta
 */
public abstract class AbstractWriter {
    
    protected String getFormattedAccountData(final Account account) {
        return String.format("%s %s", account.getAccountNumber(), 
                account.isValid() == false ? account.getError() : "");
    }
}
