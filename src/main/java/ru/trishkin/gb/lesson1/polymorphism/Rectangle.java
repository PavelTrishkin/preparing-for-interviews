package ru.trishkin.gb.lesson1.polymorphism;

public class Rectangle implements Figure {

    private double a;
    private double h;

    public Rectangle(double a, double h) {
        this.a = a;
        this.h = h;
    }

    public void calculation() {
        System.out.println("Area rectangle: " + 0.5 * a * h);
    }
}
