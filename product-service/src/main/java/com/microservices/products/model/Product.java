package com.microservices.products.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "products")
public class Product {

	@Id
	private Long id;
	
	private String modelName;
	
	private String color;
	
	private String modelNumber;

	public Product() {
		super();
	}
	
	public Product(Long id, String modelName, String color, String modelNumber) {
		super();
		this.id = id;
		this.modelName = modelName;
		this.color = color;
		this.modelNumber = modelNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	
	
	
}
