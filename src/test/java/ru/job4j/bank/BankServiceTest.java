package ru.job4j.bank;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUsers() {
        User user = new User("3234", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUsers(user);
        assertThat(bank.findByPassport("3234").get(), is(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3234", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUsers(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("34", "333"), is(Optional.empty()));
    }

    @Test
    public void addAccount() {
        User user = new User("3234", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUsers(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3234", "5546").get().getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        User user = new User("3234", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUsers(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").get().getBalance(), is(200D));
    }
}