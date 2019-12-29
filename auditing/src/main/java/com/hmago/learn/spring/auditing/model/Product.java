package com.hmago.learn.spring.auditing.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Entity
@Table(name="product")
@NoArgsConstructor
public class Product extends BaseAditableAttributes<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String name;

    private String category;

    private double price;

    private int enabled;

    @Builder(builderMethodName = "builder")
    public Product(Long id, String name, String category, double price, int enabled) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.enabled = enabled;
    }

}
