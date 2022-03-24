package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String knowledge;

    public Programmer(String name, String surname, String education, String birthday, boolean kind, String knowledge) {
        super(name, surname, education, birthday, kind);
        this.knowledge = knowledge;
    }

    public void solution(Interview interview) {
        interview.question("good");
    }

}
