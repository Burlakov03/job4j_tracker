package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + minus(a) + multiply(a) + divide(a);
    }

    public static void main(String[] args) {
        int number = 10;
        System.out.println(x + " + " + number + " = " + sum(number));
        System.out.println(number + " - " + x + " = " + minus(number));
        Calculator calculator = new Calculator();
        System.out.println(x + " * " + number + " = " + calculator.multiply(number));
        System.out.println(number + " / " + x + " = " + calculator.divide(number));
        System.out.println("Для числа " + number
                + " сумма значений для операций с ним: " + calculator.sumAllOperation(number));
    }
}
