package ru.job4j.early;

public class SearchSymbol implements ValidPassword {
    @Override
    public boolean searchUpperCase(String pass) {
        boolean result = false;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isUpperCase(pass.charAt(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean searchLowerCase(String pass) {
        boolean result = false;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isLowerCase(pass.charAt(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean searchDigit(String pass) {
        boolean result = false;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i))) {
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
        for (int i = 0; i < pass.length(); i++) {
            if (!Character.isDigit(pass.charAt(i)) && !Character.isLowerCase(pass.charAt(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean searchSubstring(String pass) {
        boolean result = false;
        String[] substrings = {
                "qwerty",
                "12345",
                "password",
                "admin",
                "user"
        };
        pass = pass.toLowerCase();
        for (String ss : substrings) {
            if (pass.contains(ss)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
