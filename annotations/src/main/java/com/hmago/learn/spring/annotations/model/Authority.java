package com.hmago.learn.spring.annotations.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name="authority")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String role;

    private String status;
}

