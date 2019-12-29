package com.hmago.learn.spring.auditing.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
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
    public Product(String name, String category, double price, int enabled) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.enabled = enabled;
    }

}
