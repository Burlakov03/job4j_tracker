package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = Integer.compare(left.length(), right.length());
        int stop = result >= 0 ? left.length() - result : left.length();
        for (int i = 0; i < stop; i++) {
            int symbol = Character.compare(left.charAt(i), right.charAt(i));
            if (symbol != 0) {
                result = symbol;
                break;
            }
        }
        return result;
    }
}
