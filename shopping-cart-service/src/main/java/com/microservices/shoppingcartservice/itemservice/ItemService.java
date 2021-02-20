package com.microservices.shoppingcartservice.itemservice;

import com.microservices.shoppingcartservice.model.Item;

public interface ItemService {

	public void createItem(Item item);

	public Item getItemById( String itemId );
}
