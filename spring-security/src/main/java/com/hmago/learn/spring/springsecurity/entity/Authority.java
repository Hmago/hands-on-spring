package com.hmago.learn.spring.springsecurity.entity;

import com.hmago.learn.spring.springsecurity.enums.AuthorityType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="authorities")
@Data
@NoArgsConstructor
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Enumerated(EnumType.STRING)
    private AuthorityType authority;
}
