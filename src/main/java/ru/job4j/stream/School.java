package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        List<Student> scholars = new ArrayList<>();
        for (Student s : students) {
            if (predicate.test(s)) {
                scholars.add(s);
            }
        }
        return scholars;
    }
}
