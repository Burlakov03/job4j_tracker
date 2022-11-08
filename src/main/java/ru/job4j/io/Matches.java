package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.print(player + " введите число от 1 до 3: ");
            int matches = Integer.parseInt(input.nextLine());
            if (matches < 1 || matches > 3) {
                System.out.println("Вы указали не правильное количество спичек. Попробуйте еще раз.");
            } else if (count - matches < 0) {
                System.out.println("Столько спичек нет на столе. Попробуйте еще раз.");
            } else {
                turn = !turn;
                count -= matches;
                System.out.println("Ход окончен. Количество спичек на столе: " + count);
            }
            System.out.println(System.lineSeparator());
        }
        System.out.println(turn ? "Выиграл второй игрок" : "Выиграл первый игрок");
    }
}
