package ru.trishkin.gb.lesson1;

import ru.trishkin.gb.lesson1.builder.Person;
import ru.trishkin.gb.lesson1.builder.PersonBuilder;
import ru.trishkin.gb.lesson1.polymorphism.Circle;
import ru.trishkin.gb.lesson1.polymorphism.Figure;
import ru.trishkin.gb.lesson1.polymorphism.Rectangle;
import ru.trishkin.gb.lesson1.polymorphism.Square;

public class MainTest {

    public static void main(String[] args) {
        testBuilder();
        testPolymorphism();
    }

    public static void testBuilder(){
        Person person;
        person = new PersonBuilder()
                .addFirstName("Test")
                .addLastName("Testov")
                .addMiddleName("Testovich")
                .addAge(35)
                .addCountry("Testovia")
                .addAddress("Test street 50")
                .addPhone("789456123")
                .addGender("man")
                .build();

        System.out.println(person.toString());
    }

    public static void testPolymorphism(){
        Figure figure = new Circle(15);
        figure.calculation();
        figure = new Square(15);
        figure.calculation();
        figure = new Rectangle(15, 2);
        figure.calculation();
    }
}
