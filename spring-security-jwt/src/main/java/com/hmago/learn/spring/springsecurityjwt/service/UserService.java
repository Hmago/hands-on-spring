package com.hmago.learn.spring.springsecurityjwt.service;

import com.hmago.learn.spring.springsecurityjwt.entity.Authority;
import com.hmago.learn.spring.springsecurityjwt.entity.User;
import com.hmago.learn.spring.springsecurityjwt.repo.AuthorityRepo;
import com.hmago.learn.spring.springsecurityjwt.repo.UserRepo;
import com.hmago.learn.spring.springsecurityjwt.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthorityRepo authorityRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        User user = userRepo.findByUsername(username);
        List<Authority> authories = authorityRepo.findByUsername(username);
        List<GrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        authories.stream().forEach(authority -> {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(authority.getRole()));
        });

        return UserPrincipal.create(user, simpleGrantedAuthorities);
    }
}
