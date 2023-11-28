package ru.job4j.oop;

import java.util.Scanner;

public class Bus  implements  Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус может ездить по автомобильным дорогам.");
    }

    @Override
    public void totalSpeed() {
        System.out.println("Автобус может максимально ехать со скоростью 90 км/ч.");
    }

    @Override
    public double fuelConsumption(double price) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите расстояние: ");
        double result = Double.parseDouble(scanner.nextLine());
        result *= price;
        return result;
    }
}
