package com.hmago.learn.spring.annotations.controller;

import com.hmago.learn.spring.annotations.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @RateLimiter(permitsPerMinutes = 2, key="1+1")
    @GetMapping("/home-page")
    public String homePage(Principal p){
        return "Welcome "+p.getName();
    }
}
