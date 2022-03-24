package ru.job4j.inheritance;

public class Engineer extends Profession {
    private boolean kind;

    public Engineer(String name, String surname, String education, String birthday, boolean kind) {
        super(name, surname, education, birthday);
        this.kind = kind;
    }

    public void form(boolean kind) {
        if (kind) {
            System.out.println("Programmer");
        } else {
            System.out.println("Builder");
        }
    }
}
