package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String teeth;

    public Dentist(String name, String surname, String education, String birthday, String problem, String teeth) {
        super(name, surname, education, birthday, problem);
        this.teeth = teeth;
    }

   public void mouth(Diagnosis diagnosis) {
        diagnosis.caries("Inspection");
   }
}
