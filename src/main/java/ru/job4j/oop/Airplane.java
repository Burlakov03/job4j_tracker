package ru.job4j.oop;

import java.util.Scanner;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет летает по небу.");
    }

    @Override
    public void totalSpeed() {
        System.out.println("Максимальная скорость самолета достигает до 11 760 км/ч. Это  X-43A.");
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
