package com.antti.bankocr.model.account.export;

import com.antti.bankocr.model.Account;
import java.io.IOException;

/**
 * @author Antti Ranta
 */
public class StdoutWriter extends AbstractWriter implements Writer {

    @Override
    public void addLine(final Account account) throws IOException {
        String data = super.getFormattedAccountData(account);
        
        String dataWithNewLine = data + System.getProperty("line.separator");
        
        System.out.println(dataWithNewLine);
    }
    
    @Override
    public void close() throws IOException {
        // Ignore
    }
}
