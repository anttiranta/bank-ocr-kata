package com.antti.bankocr.model.account.export;

import com.antti.bankocr.model.Account;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Antti Ranta
 */
public class TextFileWriter extends AbstractWriter implements Writer {

    private FileWriter fr;
    private BufferedWriter br;
    private final String outputFileName;
    
    public TextFileWriter(final String outputFileName) {
        this.outputFileName = outputFileName;
    }

    @Override
    public void addLine(final Account account) throws IOException {
        if (br == null && fr == null) {
            init();
        }
        
        String data = super.getFormattedAccountData(account);
        
        String dataWithNewLine = data + System.getProperty("line.separator");
        
        br.write(dataWithNewLine);
    }

    @Override
    public void close() throws IOException {
        br.close();
        fr.close();
    }
    
    private void init() throws IOException {
        File file = new File(outputFileName);
        fr = new FileWriter(file);
        br = new BufferedWriter(fr);
    }
}
