package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        SearchSymbol search = new SearchSymbol();
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (!search.searchUpperCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!search.searchLowerCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!search.searchDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!search.searchSpecialSymbol(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (search.searchSubstring(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }
}
