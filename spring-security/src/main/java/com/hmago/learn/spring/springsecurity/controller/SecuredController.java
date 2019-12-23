package com.hmago.learn.spring.springsecurity.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/secured")
@Log4j2
public class SecuredController {

    @GetMapping("/home-page")
//    @PreAuthorize("hasRole('ROLE_USER')")
    public String userHomePage(Principal p) {
        log.info("===accessed by =={}", p.getName());
        return "Welcome";
    }

    @GetMapping("/admin-page")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminPage(){
        log.info("==admin===");
        return "admin";
    }
}
