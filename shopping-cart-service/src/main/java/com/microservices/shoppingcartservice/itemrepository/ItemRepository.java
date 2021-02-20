package com.microservices.shoppingcartservice.itemrepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservices.shoppingcartservice.model.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String>{

}
