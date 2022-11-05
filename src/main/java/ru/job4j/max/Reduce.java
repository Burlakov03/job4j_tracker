package ru.job4j.max;

public class Reduce {
    private int[] array;

    public void to(int[] multiplicity) {
        array = multiplicity;
    }

    public void print() {
        for (int number : array) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        int[] vector = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(vector);
        reduce.print();
    }
}