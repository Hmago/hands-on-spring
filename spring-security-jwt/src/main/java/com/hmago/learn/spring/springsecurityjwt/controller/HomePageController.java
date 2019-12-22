package com.hmago.learn.spring.springsecurityjwt.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("/secured")
public class HomePageController {

    @GetMapping("/home-page")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String homePage(Principal p){
        log.info("== Loggedin Principal={}", p.getName());
        return "Welcome User";
    }

    @GetMapping("/admin-page")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminPage(Principal p){
        log.info("== Loggedin Principal={}", p.getName());
        return "Admin Page";
    }
}
