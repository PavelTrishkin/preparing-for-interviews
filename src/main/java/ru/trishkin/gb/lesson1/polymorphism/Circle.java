package ru.trishkin.gb.lesson1.polymorphism;

public class Circle implements Figure {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void calculation() {
        System.out.println("Circle radius = " + 3.14 * Math.sqrt(radius));
    }
}
