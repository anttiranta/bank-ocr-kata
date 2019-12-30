package com.antti.bankocr.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Antti Ranta
 */
public class StringUtils {

    public static List<String> splitString(String string) {
        return splitString(string, 0);
    }
    
    public static List<String> splitString(String string, int chunk) {
        List<String> array = new ArrayList<>();

        if (string.length() == 0) {
            array.add(string);
            return array;
        }

        int strLen = string.length();

        for (int i = 0; i < strLen; i += chunk) {
            String value;

            if (i + chunk <= strLen) {
                value = string.substring(i, i + chunk);
            } else {
                value = string.substring(i);
            }
            array.add(value);
        }

        return array;
    }
}
