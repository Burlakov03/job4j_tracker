package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] wordsLeft = left.split("\\.");
        String[] wordsRight = right.split("\\.");
        return Integer.compare(Integer.parseInt(wordsLeft[0]), Integer.parseInt(wordsRight[0]));
    }
}
