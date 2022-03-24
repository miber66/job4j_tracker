package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String problem;

    public Doctor() {

    }

    public Doctor(String name, String surname, String education, String birthday, String problem) {
        super(name, surname, education, birthday);
        this.problem = problem;
    }

    public void diagnose(Pacient pacient) {
        pacient.diagnose("teeth");
    }
}
