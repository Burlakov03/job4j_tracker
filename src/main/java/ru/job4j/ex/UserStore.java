package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User find = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                find = user;
                break;
            }
        }
        if (find == null) {
            throw new UserNotFoundException("User not find.");
        }
        return find;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean result = user.isValid();
        if (!result || user.getUsername().length() < 4) {
            throw new UserInvalidException("User name invalid.");
        }
        return result;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
