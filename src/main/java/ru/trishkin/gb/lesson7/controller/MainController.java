package ru.trishkin.gb.lesson7.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @PreAuthorize("isAuthenticated()")
    @RequestMapping({"", "/"})
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login_form";
    }
}
