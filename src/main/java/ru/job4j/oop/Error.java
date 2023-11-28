package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public void showError() {
        System.out.println("Состояние ошибки: " + active);
        System.out.println("Статус ошибки: " + status);
        System.out.println("Сообщение ошибки: " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error(true, 1, "Exception: s is null!");
        error1.showError();
        Error error2 = new Error(false, 2, "Exception was processed. Program continues");
        error2.showError();
        Error error3 = new Error(true, 3, "Exception: String can not be empty!");
        error3.showError();
        Error error4 = new Error();
        error4.showError();
    }
}
