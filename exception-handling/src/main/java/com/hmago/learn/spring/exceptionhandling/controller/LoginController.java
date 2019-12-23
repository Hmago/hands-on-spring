package com.hmago.learn.spring.exceptionhandling.controller;

import com.hmago.learn.spring.exceptionhandling.pojo.LoginResponse;
import com.hmago.learn.spring.exceptionhandling.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private AppService service;

    @GetMapping("/login")
    public LoginResponse login(){
        return service.login();
    }

    @GetMapping("/register")
    public LoginResponse register(){
        return service.insertDataInDB();
    }

    @GetMapping("/calculate")
    public int calculate(){
        return service.calculate();
    }
}
