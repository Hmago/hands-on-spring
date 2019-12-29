package com.hmago.learn.spring.auditing.repo;

import com.hmago.learn.spring.auditing.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepo extends JpaRepository<Authority, Long> {
}
