package com.ms.product.controller;

import com.ms.product.model.Product;
import com.ms.product.payload.ProductRequest;
import io.micrometer.observation.annotation.Observed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.product.service.ProductService;

@RestController
@RequestMapping("/productapi")
@Observed
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/products")
	public ResponseEntity<Product> createNewProduct(@RequestBody ProductRequest product){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
	}
}
