package com.ajay.spring.logging.api.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.spring.logging.api.entity.Product;
import com.ajay.spring.logging.api.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@PostConstruct
	public void initDb() {
		productRepository.saveAll(Stream.of(new Product(101, "PEN", 10.00), new Product(102, "BOOK", 105.00))
				.collect(Collectors.toList()));
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}
}
