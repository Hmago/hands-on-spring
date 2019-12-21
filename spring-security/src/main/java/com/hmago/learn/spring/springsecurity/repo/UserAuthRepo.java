package com.hmago.learn.spring.springsecurity.repo;

import com.hmago.learn.spring.springsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
