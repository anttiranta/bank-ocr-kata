package com.antti.bankocr.model.account.export;

import com.antti.bankocr.model.Account;
import java.io.Closeable;
import java.io.IOException;

/**
 * @author Antti Ranta
 */
public interface Writer extends Closeable {
    
    public void addLine(final Account account) throws IOException;
}
