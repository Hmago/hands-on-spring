package com.hmago.learn.spring.springjparelations.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author harshit.mago
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
public class University extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "university", cascade = CascadeType.ALL)
    private College college;

    @Builder(builderMethodName = "builder")
    public University(String name, College college) {
        this.name = name;
        this.college = college;
    }
}
