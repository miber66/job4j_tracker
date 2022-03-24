package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String kind;

    public Surgeon(String name, String surname, String education, String birthday, String problem, String kind) {
        super(name, surname, education, birthday, problem);
        this.kind = kind;
    }

    public void choice(NeedOperations need) {
        need.operation("Critical");
    }
}
