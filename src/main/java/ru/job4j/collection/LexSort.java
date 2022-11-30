package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result;
        String[] wordsLeft = left.split("\\.");
        String[] wordsRight = right.split("\\.");
        if (wordsLeft[0].matches("\\d+\\.\\d+") || wordsLeft[0].matches("\\d+")
                && wordsRight[0].matches("\\d+\\.\\d+") || wordsRight[0].matches("\\d+")) {
            result = Integer.compare(Integer.parseInt(wordsLeft[0]), Integer.parseInt(wordsRight[0]));
        } else {
            result = wordsLeft[0].compareTo(wordsRight[0]);
        }
        return result;
    }
}
