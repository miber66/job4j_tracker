package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {

            return users.keySet()
                    .stream()
                    .filter(u -> passport.equals(u.getPassport()))
                    .findFirst();
    }

    /**
     * Метод ищет пользователя по пасспортным данным и реквизитам,
     * если пользователь найден, то сверяет его реквизиты с заданными
     * @param passport пасспортные данные
     * @param requisite реквезиты пользователя
     * @return возращет счет пользователя или null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(u -> requisite.equals(u.getRequisite()))
                    .findFirst();
        }
        return rsl;
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
        Optional<Account> source = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (source.isPresent() && dest.isPresent() && source.get().getBalance() > 0 && source.get().getBalance() >= amount) {
            dest.get().setBalance(dest.get().getBalance() + amount);
            source.get().setBalance(source.get().getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
