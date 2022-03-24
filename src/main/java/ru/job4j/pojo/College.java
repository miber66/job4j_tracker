package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivanov Ivan Petrovich");
        student.setGroup("Chemistry");
        student.setDate(new Date(120, 6, 15));

        System.out.println(student.getFullName()
                + System.lineSeparator() + student.getGroup()
                + System.lineSeparator() + student.getDate());
    }
}
