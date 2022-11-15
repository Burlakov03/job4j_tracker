package ru.job4j.early;

public class SearchSymbol implements ValidPassword {
    private static final String[] SUBSTRINGS = {
            "qwerty",
            "12345",
            "password",
            "admin",
            "user"
    };

    @Override
    public boolean searchUpperCase(String pass) {
        boolean result = false;
        for (char ch : pass.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean searchLowerCase(String pass) {
        boolean result = false;
        for (char ch : pass.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean searchDigit(String pass) {
        boolean result = false;
        for (char ch : pass.toCharArray()) {
            if (Character.isDigit(ch)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean searchSpecialSymbol(String pass) {
        boolean result = false;
        pass = pass.toLowerCase();
        for (char ch : pass.toCharArray()) {
            if (!Character.isDigit(ch) && !Character.isLowerCase(ch)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean searchSubstring(String pass) {
        boolean result = false;
        pass = pass.toLowerCase();
        for (String ss : SUBSTRINGS) {
            if (pass.contains(ss)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
