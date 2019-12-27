package com.hmago.learn.spring.annotations.repo;

import com.hmago.learn.spring.annotations.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
