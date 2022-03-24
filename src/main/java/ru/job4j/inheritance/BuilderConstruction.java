package ru.job4j.inheritance;

public class BuilderConstruction {
    BuilderConstruction builder = new BuilderConstruction();

    public String construction(int[] money) {
        String result = "";
        for (int i = 0; i < money.length; i++) {
            money[i] = i;
            if (i > 10000000) {
                result = "Shopping centre";
            } else {
                result = "Multi-storey building";
            }
        }
        return result;
    }
}
