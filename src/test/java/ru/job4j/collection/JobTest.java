package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void whenComparatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("impl task", 0),
                new Job("fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByName() {
        List<Job> list = Arrays.asList(
                new Job("Programmer", 1),
                new Job("Builder", 0),
                new Job("Baker", 2)
        );
        Collections.sort(list, new JobAskByName());
        assertThat(list.get(0).getName(), is("Baker"));
    }

    @Test
    public void whenComparatorDescByName() {
        List<Job> list = Arrays.asList(
                new Job("Programmer", 1),
                new Job("Builder", 0),
                new Job("Baker", 2)
        );
        Collections.sort(list, new JobDescByName());
        assertThat(list.get(0).getName(), is("Programmer"));
    }

    @Test
    public void whenComparatorAscByPriority() {
        List<Job> list = Arrays.asList(
                new Job("Programmer", 0),
                new Job("Builder", 1),
                new Job("Baker", 2)
        );
        Collections.sort(list, new JobAskByPriority());
        assertThat(list.get(0).getPriority(), is(0));
    }

    @Test
    public void whenComparatorDescByPriority() {
        List<Job> list = Arrays.asList(
                new Job("Programmer", 0),
                new Job("Builder", 1),
                new Job("Baker", 2)
        );
        Collections.sort(list, new JobDescByPriority());
        assertThat(list.get(0).getPriority(), is(2));
    }

    @Test
    public void whenComparatorAscByNameAndPriority() {
        Comparator<Job> comparator = new JobAskByName().thenComparing(new JobAskByPriority());
        int rsl = comparator.compare(
                new Job("Programmer", 0),
                new Job("Builder", 1)
                );
        assertThat(rsl, greaterThan(2));
    }
}