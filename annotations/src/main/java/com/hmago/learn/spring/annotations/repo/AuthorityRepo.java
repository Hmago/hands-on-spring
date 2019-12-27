package com.hmago.learn.spring.annotations.repo;

import com.hmago.learn.spring.annotations.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepo extends JpaRepository<Authority, Long> {
}
