package com.devsuperior.dsecommerce.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsecommerce.entities.Product;
import com.devsuperior.dsecommerce.repositories.ProductRepository;

@RestController
@RequestMapping(value="/products")
public class ProductController{
	
	private ProductRepository repository;
	
	@GetMapping
	public String test() {
		 Optional<Product> result = repository.findById(1L);
		 Product product = result.get();
		 return product.getName();
	}
}
