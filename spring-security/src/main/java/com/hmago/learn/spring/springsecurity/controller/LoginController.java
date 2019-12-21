package com.hmago.learn.spring.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open")
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "This is login page and no authentication is applied on this.";
    }
}
