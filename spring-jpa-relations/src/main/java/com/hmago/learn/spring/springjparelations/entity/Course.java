package com.hmago.learn.spring.springjparelations.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * @author harshit.mago
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course extends AbstractEntity {
    @Column(nullable = false)
    private String name;

    @ManyToOne
    private College college;

    @OneToMany(mappedBy = "course")
    private Set<CourseStudentMapping> studentMapping;

    @Builder(builderMethodName = "builder")
    public Course(String name, College college, Set<CourseStudentMapping> studentMapping) {
        this.name = name;
        this.college = college;
        this.studentMapping = studentMapping;
    }
}
