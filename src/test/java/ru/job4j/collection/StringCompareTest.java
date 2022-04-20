package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringCompareTest {
    @Test
    public void whenEqualsThenZero() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rsl, is(0));
    }

    @Test
    public void whenLeftLessThenRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenRightLessThenLeftResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Ivanova",
                "Ivanov"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenOtherWords() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare(
                "Sidorov",
                "Ivanov"
        );
        assertThat(rsl, greaterThan(0));
    }
}