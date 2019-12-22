package com.hmago.learn.spring.springSecurityoAuth2.service;

import com.hmago.learn.spring.springSecurityoAuth2.entity.User;
import com.hmago.learn.spring.springSecurityoAuth2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public User loadUserByName(String username){
        return repo.findUserByUsername(username);
    }
}
