package com.hmago.learn.spring.auditing.repo;

import com.hmago.learn.spring.auditing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long
        > {
}
