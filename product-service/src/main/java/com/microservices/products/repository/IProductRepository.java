package com.microservices.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservices.products.model.Product;

@Repository
public interface IProductRepository extends MongoRepository<Product, Long>{

}
