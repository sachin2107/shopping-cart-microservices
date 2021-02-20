package com.microservices.products.service;

import com.microservices.products.model.Product;

public interface IProductService {

	public Product retrieveProduct( Long productId );
	
	public void createProduct( Product product );
}
