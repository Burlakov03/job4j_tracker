package ru.job4j.oop;

import java.util.Scanner;

public class ChoiceTransport {

    public static void main(String[] args) {
        Vehicle air = new Airplane();
        Vehicle trian = new Train();
        Vehicle bus = new Bus();
        Vehicle[] transports = new Vehicle[] {air, trian, bus};
        System.out.println("Основываясь на информации о траспорте выберите нужный вам.");
        for (Vehicle transport : transports) {
            transport.move();
            transport.totalSpeed();
            System.out.println(System.lineSeparator());
        }
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean result;
        do {
            System.out.print("Выберите транспорт: " + System.lineSeparator()
                    + "1) Самолет." + System.lineSeparator()
                    + "2) Поезд." + System.lineSeparator()
                    + "3) Машина." + System.lineSeparator()
                    + "Ваш выбор:");
            choice = Integer.parseInt(scanner.nextLine());
            result = choice < 1 || choice > 3;
            if (result) {
                System.out.println("Вы указали не существующий транспорт.");
            }
        } while (result);
        System.out.println("Приступаем к расчету стоимости проезда.");
        System.out.print("Введите цену за 1 единицу расстояния: ");
        double price = Double.parseDouble(scanner.nextLine());
        price = switch (choice) {
            case 1 -> transports[0].fuelConsumption(price);
            case 2 -> transports[1].fuelConsumption(price);
            case 3 -> transports[2].fuelConsumption(price);
            default -> 0;
        };
        System.out.println("Проезд обойдется вам в : " + price + " y.e.");
    }
}
