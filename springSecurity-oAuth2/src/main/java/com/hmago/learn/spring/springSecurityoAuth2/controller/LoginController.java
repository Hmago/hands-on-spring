package com.hmago.learn.spring.springSecurityoAuth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/client")
    public String loginClient(){
        return "Clinet login page[No Auth required] ";
    }

}
