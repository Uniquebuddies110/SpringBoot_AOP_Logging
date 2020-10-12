package com.ajay.spring.logging.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajay.spring.logging.api.entity.Product;
import com.ajay.spring.logging.api.service.ProductService;

@Controller
@RequestMapping("/product/api")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/add")
	@ResponseBody
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@GetMapping("/findAll")
	@ResponseBody
	public List<Product> findAllProducts() {
		return productService.findAllProducts();
	}
}
