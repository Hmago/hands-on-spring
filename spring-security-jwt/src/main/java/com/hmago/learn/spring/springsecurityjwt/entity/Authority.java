package com.hmago.learn.spring.springsecurityjwt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="authority", indexes = {@Index(name = "username", columnList = "username")})
@Data
@NoArgsConstructor
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String role;

    private int enabled=1;
}
