package com.antti.bankocr.model.validator;

import com.antti.bankocr.model.DigitChunk;

/**
 * @author Antti Ranta
 */
public class AccountLinesValidator
{
    public boolean isValid(DigitChunk digitChunk)
    {
        int numRows = digitChunk.getOcrDigits().size();
        int numColumns = digitChunk.getOcrDigits().get(0).length();
        
        if (numColumns != DigitChunk.ENTRY_CHAR_AMOUNT){
            return false;
        }
        
        if (numRows < 1
            || (numRows % DigitChunk.ENTRY_LINES_AMOUNT != 0)
            || numColumns < 1
            || (numColumns % DigitChunk.ACCOUNT_NUMBER_LINES_AMOUNT != 0)
        ) {
            return false;
        }
        
        for (String row : digitChunk.getOcrDigits()) {
            if (row.length() != numColumns) {
                return false;
            }
        }
        return true;
    }
}
