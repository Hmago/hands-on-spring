package com.hmago.learn.spring.springsecurity.service;

import com.hmago.learn.spring.springsecurity.entity.User;
import com.hmago.learn.spring.springsecurity.repo.UserAuthRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserAuthService {

    @Autowired
    private UserAuthRepo repo;

    public User loadUserByUsername(String username){
        return repo.findByUsername(username);
    }
}
