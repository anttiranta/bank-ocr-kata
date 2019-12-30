package com.antti.bankocr.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Antti Ranta
 */
public class DigitsMapper 
{
    public static final char ILLEGIBLE_OCR_DIGIT = '?';
    
    private static final Map<String, Character> DIGITS_MAP = new HashMap<String, Character>() {{
        put("*_*|*||_|***", '0');
        put("*****|**|***", '1');
        put("*_**_||_****", '2');
        put("*_**_|*_|***", '3');
        put("***|_|**|***", '4');
        put("*_*|_**_|***", '5');
        put("*_*|_*|_|***", '6');
        put("*_***|**|***", '7');
        put("*_*|_||_|***", '8');
        put("*_*|_|*_|***", '9');
    }};
    
    public Character map(String digitCanditate) {
        String preparedStr = digitCanditate.replace(' ', '*');
        return DIGITS_MAP.containsKey(preparedStr) 
                ? DIGITS_MAP.get(preparedStr) 
                : ILLEGIBLE_OCR_DIGIT;
    }
    
    public Character map(List<String> digitCanditate) {
        return this.map(String.join("", digitCanditate));
    }
}
