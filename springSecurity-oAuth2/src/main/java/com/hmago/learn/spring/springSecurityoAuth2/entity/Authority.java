package com.hmago.learn.spring.springSecurityoAuth2.entity;

import com.hmago.learn.spring.springSecurityoAuth2.enums.AuthorityType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
@Data
@NoArgsConstructor
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @Enumerated(EnumType.STRING)
    private AuthorityType authority;

    private int enabled = 1;
}
