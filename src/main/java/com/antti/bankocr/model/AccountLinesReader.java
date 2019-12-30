package com.antti.bankocr.model;

import com.antti.bankocr.exception.LogicException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antti Ranta
 */
public class AccountLinesReader {

    private static final int MAX_ENTRIES_READ_ITERATIONS = 500;

    private BufferedReader reader;

    public AccountLinesReader(final File file) throws FileNotFoundException {
        this.reader = new BufferedReader(new java.io.FileReader(file));
    }
    
    public AccountLinesReader(final String lines) {
        this.reader = new BufferedReader(new StringReader(lines));
    }

    public List<DigitChunk> getAllAccountLines() throws Exception {
        List<DigitChunk> accountLines = new ArrayList<>();

        int i = 0;
        while (i++ < MAX_ENTRIES_READ_ITERATIONS) {
            try {
                DigitChunk digitChunk = this.getNextAccountLines();
                if (digitChunk == null) {
                    break;
                }
                accountLines.add(digitChunk);
            } catch (LogicException le) {
                accountLines.add(this.createEmptyDigitChunk());
            }
        }

        if (i > MAX_ENTRIES_READ_ITERATIONS) {
            throw new Exception(
                    getClass().getSimpleName()
                    + " reached " + MAX_ENTRIES_READ_ITERATIONS
                    + " entries read iterations"
            );
        }
        return accountLines;
    }

    protected DigitChunk getNextAccountLines() throws IOException, LogicException {
        List<String> ocrDigits = new ArrayList<>();

        for (int i = 0; i < DigitChunk.ENTRY_LINES_AMOUNT; i++) {
            String line = this.reader.readLine();
            
            if (line != null) {
                for (String digits : String.format(
                        "%0$-" + DigitChunk.ENTRY_CHAR_AMOUNT + "s", line)
                        .split("(?<=\\G.{" + DigitChunk.ENTRY_CHAR_AMOUNT + "})")) {
                    try {
                        ocrDigits.set(i, digits);
                    } catch (IndexOutOfBoundsException ioobe) {
                        ocrDigits.add(digits);
                    }
                }
                continue;
            }
            
            if(ocrDigits.size() == DigitChunk.ACCOUNT_NUMBER_LINES_AMOUNT){
                ocrDigits.add(String.format(
                        "%1$" + DigitChunk.ENTRY_CHAR_AMOUNT + "s", ""));
                break;
            }
            return null;
        }

        if (ocrDigits.size() == DigitChunk.ENTRY_LINES_AMOUNT) {
            DigitChunk digitChunk = new DigitChunk(ocrDigits);
            return digitChunk;
        }

        throw new LogicException("Could not read account lines");
    }
    
    private DigitChunk createEmptyDigitChunk() {
        return new DigitChunk(new ArrayList<String>());
    }
}
