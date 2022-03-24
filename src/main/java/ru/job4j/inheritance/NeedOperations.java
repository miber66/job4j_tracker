package ru.job4j.inheritance;

public class NeedOperations {
    NeedOperations need = new NeedOperations();

    public String operation(String kind) {
        String rsl = "";
        if (kind == "Critical") {
            rsl = "Need operation";
        } else {
            rsl = "Need treatment";
        }
        return rsl;
    }
}
