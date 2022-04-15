package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUsers(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User person : users.keySet()) {
            if (passport.equals(person.getPassport())) {
                return person;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPasport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account source = findByRequisite(srcPasport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (source != null && dest != null && source.getBalance() > 0 && source.getBalance() >= amount) {
            dest.setBalance(dest.getBalance() + amount);
            source.setBalance(source.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
