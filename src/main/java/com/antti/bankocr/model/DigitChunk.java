package com.antti.bankocr.model;

import java.util.List;

/**
 * @author Antti Ranta
 */
public class DigitChunk {

    public static final int ENTRY_CHAR_AMOUNT = 27;
    public static final int ENTRY_LINES_AMOUNT = 4;
    public static final int ACCOUNT_NUMBER_LINES_AMOUNT = 3;
    
    private final List<String> ocrDigits;
    
    public DigitChunk(final List<String> ocrDigits){
        this.ocrDigits = ocrDigits;
    }

    public List<String> getOcrDigits() {
        return ocrDigits;
    }
}
