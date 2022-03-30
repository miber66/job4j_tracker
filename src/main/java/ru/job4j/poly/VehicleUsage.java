package ru.job4j.poly;

public class VehicleUsage {
    public static void main(String[] args) {
        Airplane airplane = new Airplane();
        Train train = new Train();
        Autobus autobus = new Autobus();
        Vehicle first = (Airplane) airplane;
        Vehicle second = (Train) train;
        Vehicle third = (Autobus) autobus;
        Vehicle[] transport = {first, second, third};
        for (Vehicle a : transport) {
            a.move();
            a.engine();
            System.out.println();
        }
    }
}
