package ru.job4j.checkstyle;

public class Broken {
    private int sizeOfEmpty = 10;
    public String surname;
    public String name;
    public static final String NEWVALUE = "";

    Broken() {
    }

    void echo() {
    }

    void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    void method(int a, int b, int c, int d) {

    }
}