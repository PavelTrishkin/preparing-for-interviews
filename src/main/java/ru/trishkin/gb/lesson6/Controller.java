package ru.trishkin.gb.lesson6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String getHello(){
        return "GET HELLO FROM SPRING SERVER";
    }

    @PostMapping("/hello")
    public String postHello(){
        return "POST HELLO FROM SPRING SERVER";
    }

    @GetMapping("/person")
    public Person getPerson(){
        return new Person("Bob", "test@mail.ru");
    }
}
