package ru.job4j.inheritance;

public class Builder extends Engineer {
    private int[] money;

    public Builder(String name, String surname, String education, String birthday, boolean kind, int[] money) {
        super(name, surname, education, birthday, kind);
        this.money = money;
    }

     public void info(BuilderConstruction builder) {
        builder.construction(new int[] {10000, 200000});
     }
}
