package com.hmago.learn.spring.auditing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="authority")
@Data
@NoArgsConstructor
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String role;

    private int enabled;

    @Builder(builderMethodName = "builder")
    public Authority(Long id, String username, String role, int enabled) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.enabled = enabled;
    }
}
