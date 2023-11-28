package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу простейшего банковского сервиса, который позволяет
 * добавлять,удалять пользователей банка, осуществлять их поиск по паспорту
 * а так же добавлять и производить переводы между счетами
 * @author Владимир Бурлаков
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных о пользователях осуществляется в ассоциативном массиве
     * где ключ это пользователь а значение его счета хранящиеся в коллекции типа Account
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в базу без счетов.
     * Метод не дает добавить пользователя который уже есть в базе.
     * @param user пользователь который добавляется в базу.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод производит удаление пользователя из базы.
     * @param passport это номер паспорта пользователя(являющийся уникальным)
     *                 по которому осуществляется поиск пользователя
     * @return Вернет true если пользователь удален,
     *         вернет false если пользователь с указанным паспортом не существует
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет счет пользователю, если указанный пользователь существует,
     * и у него нет такого же счета.
     * @param account новый счет для добавления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод позволяет получить пользователя по паспорту
     * @return возвращает пользователя с указанным паспортом либо null если такого нет
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод позволяет получить счет пользователя на основание паспорта и реквизита счета
     * @param requisite реквизит искомого счета
     * @return возвращает счет соответствующий указанным параметрам либо null если такго счета нет
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод осуществляет перевод денег между счетами
     * в случае их существования и наличия требуемой суммы на счете отправителя
     * @param amount сумма которую необходимо перевести
     * @return вернет true если перевод был осуществлен,
     *         вернет false если один из счетов не найден либо если на счете отправителя недостаточно денег
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && srcAccount.getBalance() >= amount && destAccount != null) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод возвращает счета указанного пользователя
     * @return возвращает счета пользователя из базы, если такого пользователя нет вернется null
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
