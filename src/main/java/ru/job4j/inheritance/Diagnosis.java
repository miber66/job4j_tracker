package ru.job4j.inheritance;

public class Diagnosis {
    Diagnosis diagnosis = new Diagnosis();

    public String caries(String teeth) {
        String rsl = "";
        if (teeth == "Caries") {
            rsl = "Treatment";
        } else {
            rsl = "Inspection";
        }
        return rsl;
    }
}
