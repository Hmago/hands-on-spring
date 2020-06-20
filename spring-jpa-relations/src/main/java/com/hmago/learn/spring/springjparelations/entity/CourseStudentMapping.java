package com.hmago.learn.spring.springjparelations.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author harshit.mago
 */
@Entity
@Data
@Builder
public class CourseStudentMapping extends AbstractEntity {

    @ManyToOne
    private Course course;

    @ManyToOne
    private Student student;
}
