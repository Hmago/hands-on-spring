package com.hmago.learn.spring.springjparelations.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author harshit.mago
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class College extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @OneToOne
    private University university;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    private Set<Course> courseList;

    @Builder(builderMethodName = "builder")
    public College(String name, University university, Set<Course> courseList) {
        this.name = name;
        this.university = university;
        this.courseList = courseList;
    }
}
