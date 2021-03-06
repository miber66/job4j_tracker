package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(8, 0.001));
    }

    @Test
    public void when11and00and100ThenMinus1() {
        Point a = new Point(1, 1);
        Point b = new Point(0, 0);
        Point c = new Point(100, 100);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(-1, 0.001));
    }

    @Test
    public void when() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(3, 0, 0);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(3, 0.001));
    }
}