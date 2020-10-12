package com.ajay.spring.logging.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.spring.logging.api.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
