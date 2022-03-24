package ru.job4j.inheritance;

public class Interview {
    Interview interview = new Interview();

    public void question(String knowledge) {
        if (knowledge == "good") {
            System.out.println("Congratulation! You are middle");
        } else {
            System.out.println("Sorry. You are junior");
        }
    }
}
