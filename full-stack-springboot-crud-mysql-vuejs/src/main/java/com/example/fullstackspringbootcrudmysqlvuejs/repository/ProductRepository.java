package com.example.fullstackspringbootcrudmysqlvuejs.repository;

import com.example.fullstackspringbootcrudmysqlvuejs.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
