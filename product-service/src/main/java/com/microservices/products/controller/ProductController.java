package com.microservices.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.products.model.Product;
import com.microservices.products.service.IProductService;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@GetMapping("/getproducts/{productId}")
	public ResponseEntity<Product> retrieveProduct( @PathVariable Long productId ) {
		Product retrievedProduct = productService.retrieveProduct( productId );
		HttpHeaders headers = new HttpHeaders();
		headers.add("productHeader", "product header");
		return new ResponseEntity( retrievedProduct, headers, HttpStatus.FOUND );
		
	}
	
	@PostMapping("/createproduct")
	public ResponseEntity<Void> createProduct( @RequestBody Product product ) {
		productService.createProduct( product );
		return new ResponseEntity<Void>( HttpStatus.CREATED );
	}
	
}