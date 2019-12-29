package com.hmago.learn.spring.auditing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private int enabled;

    @Builder(builderMethodName = "builder")
    public User(Long id, String username, String password, int enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }
}
