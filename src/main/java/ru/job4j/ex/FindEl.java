package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element Not Found");
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        boolean results = true;
        for (String s: abuses) {
            if (s.equals(value)) {
                results = false;
                break;
            }
        }
        if (!results) {
            throw  new ElementAbuseException("Element Abuse");
        }
        return results;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] s = {"dert", "r", "dwed"};
        try {
            indexOf(s, "1");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
