package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void whenSent1() {
        List<Account> accounts = Arrays.asList(
                new Account("567", "Petr Arsentev", "000005"),
                new Account("567", "Petr Arsentev", "000005")
        );
        HashSet<Account> expect = new HashSet<>(
                List.of(
                        new Account("567", "Petr Arsentev", "000005")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}