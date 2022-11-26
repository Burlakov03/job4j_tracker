package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public boolean deleteUser(String passport) {
        return users.remove(findByPassport(passport)) != null;
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
                users.put(user, accounts);
            }
        }
    }

    public User findByPassport(String passport) {
        User search = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                search = user;
                break;
            }
        }
        return search;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account searchAccount = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    searchAccount = account;
                    break;
                }
            }
        }
        return searchAccount;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        User srcUser = findByPassport(srcPassport);
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        User destUser = findByPassport(destPassport);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && srcAccount.getBalance() >= amount && destUser != null && destAccount != null) {
            List<Account> destAccounts = users.get(destUser);
            List<Account> srcAccounts = users.get(srcUser);
            destAccounts = updateBalanceAccount(destAccounts, destAccount, amount);
            srcAccounts = updateBalanceAccount(srcAccounts, srcAccount, amount * -1);
            users.put(destUser, destAccounts);
            users.put(srcUser, srcAccounts);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> updateBalanceAccount(List<Account> accounts, Account upAccount, double amount) {
        for (Account account : accounts) {
            if (account.equals(upAccount)) {
                account.setBalance(account.getBalance() + amount);
                break;
            }
        }
        return accounts;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
