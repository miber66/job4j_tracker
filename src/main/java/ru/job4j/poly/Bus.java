package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Bus rides");
    }

    @Override
    public void passengers(int pas) {
        System.out.println("Numbers of passengers " + pas);
    }

    @Override
    public double price(double refuel) {
        int cost = 45;
        return refuel * cost;
    }
}
