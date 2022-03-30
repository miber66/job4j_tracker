package ru.job4j.poly;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Flies through the air");
    }

    @Override
    public void engine() {
        System.out.println(getClass().getSimpleName() + " Has a jet engine");
    }
}