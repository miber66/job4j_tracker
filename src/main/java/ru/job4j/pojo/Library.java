package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Crime and Punishment", 600);
        Book book2 = new Book("Demons", 402);
        Book book3 = new Book("Clean code", 584);
        Book book4 = new Book("Java for beginners", 400);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (Book bk : books) {
            System.out.println(bk.getName() + "-" + bk.getNumber());
        }
        System.out.println();
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book bk : books) {
            System.out.println(bk.getName() + "-" + bk.getNumber());
        }
        System.out.println();
        for (Book bk : books) {
            if ("Clean code".equals(bk.getName())) {
                System.out.println(bk.getName() + "-" + bk.getNumber());
            }
        }
    }
}
