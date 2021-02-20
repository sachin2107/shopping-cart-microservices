package com.microservices.shoppingcartservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.shoppingcartservice.model.Cart;

@RestController
@RequestMapping(path = "/carts")
public class CartsController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @GetMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE )
    public Cart get(@PathVariable String customerId) {
        return new Cart();
    }
	
    @DeleteMapping(value = "/{customerId}" )
    public void delete(@PathVariable String customerId) {
        new Cart();
    }
}
