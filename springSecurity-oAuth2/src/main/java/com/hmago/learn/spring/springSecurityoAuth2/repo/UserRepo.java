package com.hmago.learn.spring.springSecurityoAuth2.repo;

import com.hmago.learn.spring.springSecurityoAuth2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
