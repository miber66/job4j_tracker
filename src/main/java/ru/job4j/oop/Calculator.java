package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int a) {
        return x + a;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int divide(int a) {
        return a / x;
    }

  public int sumAllOperation(int d) {
        return sum(d) + multiply(d) + minus(d) + divide(d);
  }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(Calculator.sum(5));
        System.out.println(calculator.multiply(2));
        System.out.println(Calculator.minus(10));
        System.out.println(calculator.divide(10));
        System.out.println(calculator.sumAllOperation(10));
    }
}
