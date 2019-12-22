package com.hmago.learn.spring.springSecurityoAuth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured")
public class HomePageController {

    @GetMapping("/home-page")
    public String homePage(){
        return "Welcome to your home page";
    }

    @GetMapping("/admin-page")
    public String adminPage(){
        return "Wlcome to admin page";
    }
}
