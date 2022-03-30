package ru.job4j.poly;

public class Autobus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Rides on road");
    }

    @Override
    public void engine() {
        System.out.println(getClass().getSimpleName() + " Has a petrol engine");
    }
}
