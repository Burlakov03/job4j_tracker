package ru.job4j.oop;

import java.util.Scanner;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд ездит по рельсам.");
    }

    @Override
    public void totalSpeed() {
        System.out.println("Максимальная скорость поезда достигает 430 км/ч. Это Шанхайский маглев.");
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
