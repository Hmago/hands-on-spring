package com.hmago.learn.spring.auditing.repo;

import com.hmago.learn.spring.auditing.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
