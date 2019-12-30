package com.antti.bankocr.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Antti Ranta
 */
public class ListUtils {

    public static <T> List<List<T>> chunk(List<T> list, int size) throws IllegalArgumentException {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be > 0 : " + size);
        }

        List<List<T>> result = new ArrayList<>();

        int from = 0;
        int to = size >= list.size() ? list.size() : size;

        while (from < list.size()) {
            List<T> subArray = list.subList(from, to);
            from = to;
            to += size;
            if (to > list.size()) {
                to = list.size();
            }
            result.add(subArray);
        }
        return result;
    }

    public static <T> List<List<T>> zip(List<T>... a) throws IllegalArgumentException {
        List<List<T>> joinedList = new ArrayList<>();

        List<T> argument1 = a[0];
        final Class<?> type1 = argument1.getClass().getComponentType();
        final int size1 = argument1.size();

        for (int i = 0; i < size1; i++) {
            List<T> chunk = new ArrayList<>();
            
            for (List<T> argument : a) {
                try {
                    chunk.add(argument.get(i));
                } catch (ClassCastException cce) {
                    final Class<?> type2 = argument.getClass().getComponentType();
                    if (!type1.isAssignableFrom(type2)) {
                        throw new IllegalArgumentException("Cannot store " + type2.getName() + " in a list of "
                                + type1.getName(), cce);
                    }
                    throw cce;
                }
            }
            
            joinedList.add(chunk);
        }
        
        return joinedList;
    }
}
