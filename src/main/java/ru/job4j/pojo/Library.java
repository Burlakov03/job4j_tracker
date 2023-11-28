package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 1180);
        Book book2 = new Book("Morze", 180);
        Book book3 = new Book("Black sky", 220);
        Book book4 = new Book("Magic words", 540);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        System.out.println("List of books in the library before replacement:");
        for (int index = 0; index < books.length; index++) {
            System.out.println("Book: " + books[index].getName() + ". Number of page: " + books[index].getCount());
        }
        Book temp = new Book();
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println(System.lineSeparator() + "List of books in the library after replacement:");
        for (int index = 0; index < books.length; index++) {
            System.out.println("Book: " + books[index].getName() + ". Number of page: " + books[index].getCount());
        }
        System.out.println(System.lineSeparator() + "According to your request: Clean code book:");
        for (int index = 0; index < books.length; index++) {
            if ("Clean code".equals(books[index].getName())) {
                System.out.println("Book: " + books[index].getName() + ". Number of page: " + books[index].getCount());
                break;
            }
        }
    }
}
