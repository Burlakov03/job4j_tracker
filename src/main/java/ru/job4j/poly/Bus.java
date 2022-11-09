package ru.job4j.poly;

import java.util.Scanner;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус едет бу-бу-бу");
    }

    @Override
    public void passengers(int amount) {
        System.out.println("Количество пассажиров в автобусе: " + amount);
    }

    @Override
    public double refuel(double amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите цену за 1 литр топлива: ");
        double price = Double.parseDouble(scanner.nextLine());
        return amount * price;
    }
}
