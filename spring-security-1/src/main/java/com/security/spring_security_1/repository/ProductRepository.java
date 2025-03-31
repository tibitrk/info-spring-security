package com.security.spring_security_1.repository;

import com.security.spring_security_1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
