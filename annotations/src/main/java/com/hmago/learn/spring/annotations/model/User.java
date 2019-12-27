package com.hmago.learn.spring.annotations.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private int status;
}
