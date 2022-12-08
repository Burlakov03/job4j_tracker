package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("/");
        String[] second = o2.split("/");
        int rsl = second[0].compareTo(first[0]);
        if (rsl == 0) {
            if (first.length != second.length) {
                rsl = o1.compareTo(o2);
            } else {
                for (int i = 1; i < first.length; i++) {
                    rsl = first[i].compareTo(second[i]);
                    if (rsl != 0) {
                        break;
                    }
                }
            }
        }
        return rsl;
    }
}
