package com.hmago.learn.spring.springjparelations.repo;

import com.hmago.learn.spring.springjparelations.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author harshit.mago
 */
@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
}
