package com.microservices.products.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.products.model.Product;
import com.microservices.products.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productRepository;
	
	@Override
	public Product retrieveProduct( Long productId) {
		Optional<Product> product = productRepository.findById( productId );
		return product.orElse(new Product());
	}

	@Override
	public void createProduct(Product product) {
		productRepository.save( product );
	}

}
