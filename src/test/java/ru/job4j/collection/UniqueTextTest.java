package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UniqueTextTest {

    @Test
    public void isEquals() {
        String origin = "My cat eats a mouse and milk";
        String duplicate = "My cat eats milk and a mouse";
        assertThat(UniqueText.isEquals(origin, duplicate), is(true));
    }

    @Test
    public void isNotEquals() {
        String origin = "My cat eats a mouse";
        String duplicate = "A mouse is eaten by cat";
        assertThat(UniqueText.isEquals(origin, duplicate), is(false));
    }
}