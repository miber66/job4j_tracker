package ru.job4j.oop;

public class Ball {

    void tryRun(boolean condition) {
        if (condition) {
            System.out.println("Ball is eaten");
        } else {
            System.out.println("Ball is run");
        }
    }
}
