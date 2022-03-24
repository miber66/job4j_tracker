package ru.job4j.inheritance;

public class Pacient {
    Pacient pacient = new Pacient();

    public String diagnose(String problem) {
        String rsl = "";
        if (problem == "teeth") {
            rsl = "Dentist";
        } else {
            rsl = "Surgeon";
        }
        return rsl;
    }
}
