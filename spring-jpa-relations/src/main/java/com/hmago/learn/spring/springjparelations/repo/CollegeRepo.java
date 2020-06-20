package com.hmago.learn.spring.springjparelations.repo;

import com.hmago.learn.spring.springjparelations.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author harshit.mago
 */
@Repository
public interface CollegeRepo extends JpaRepository<College, Long> {
}
