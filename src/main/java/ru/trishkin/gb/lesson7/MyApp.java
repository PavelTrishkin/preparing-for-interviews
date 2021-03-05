package ru.trishkin.gb.lesson7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MyApp.class, args);
    }
}
