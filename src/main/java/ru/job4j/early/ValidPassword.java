package ru.job4j.early;

public interface ValidPassword {
    boolean searchUpperCase(String pass);

    boolean searchLowerCase(String pass);

    boolean searchDigit(String pass);

    boolean searchSpecialSymbol(String pass);

    boolean searchSubstring(String pass);
}
