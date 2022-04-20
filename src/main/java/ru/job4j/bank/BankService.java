package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу со счетами пользователя
 * банковского приложения
 * @author MARK KHOKHLYAVIN
 * @version 1.0
 */
public class BankService {
    /**
     * Коллекция Map хранит всех пользователей банка и их счета
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод проверяет наличие пользователя в системе, при его отсутствии
     * добавляет нового пользователя в коллекцию
     * @param user человек который добавляется в систему банка
     */
    public void addUsers(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод создает счет пользователя, если он присутствует в системе
     * и ранее не открывал счет с такими же реквизитами
     * @param passport пасспортные данные пользователя
     * @param account реквезиты счета пользователя
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
     * Метод ищет пользователя по паспортным данным,
     * если ползователь отсутствует возвращает null
     * @param passport пасспортные данные
     * @return возвращает null если пользователь не найден
     */
    public User findByPassport(String passport) {
        for (User person : users.keySet()) {
            if (passport.equals(person.getPassport())) {
                return person;
            }
        }
        return null;
    }

    /**
     * Метод ищет пользователя по пасспортным данным и реквизитам,
     * если пользователь найден, то сверяет его реквизиты с заданными
     * @param passport пасспортные данные
     * @param requisite реквезиты пользователя
     * @return возращет счет пользователя или null
     */
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

    /**
     * Метод переводит деньги с одного счета на другой
     * @param srcPassport пасспортные данные отправителя
     * @param srcRequisite реквизиты отправителя
     * @param destPassport пасспортные данные
     * @param destRequisite реквизиты получателя
     * @param amount сумма перевода
     * @return возвращает true если успешно, false если нет
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account source = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (source != null && dest != null && source.getBalance() > 0 && source.getBalance() >= amount) {
            dest.setBalance(dest.getBalance() + amount);
            source.setBalance(source.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
