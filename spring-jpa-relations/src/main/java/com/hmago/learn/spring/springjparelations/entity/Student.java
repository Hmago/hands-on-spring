package com.hmago.learn.spring.springjparelations.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * @author harshit.mago
 */
@Entity
@Data
@Builder
public class Student extends AbstractEntity {
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "student")
    private Set<CourseStudentMapping> courseMapping;
}
