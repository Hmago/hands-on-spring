package com.hmago.learn.spring.springsecurityjwt.repo;

import com.hmago.learn.spring.springsecurityjwt.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepo extends JpaRepository<Authority, Long> {
    List<Authority> findByUsername(String username);
}

