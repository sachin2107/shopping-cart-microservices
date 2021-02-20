package com.microservices.shoppingcartservice.itemservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.shoppingcartservice.itemrepository.ItemRepository;
import com.microservices.shoppingcartservice.model.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepo;
	
	@Override
	public void createItem(Item item) {
		itemRepo.save(item);		
	}

	@Override
	public Item getItemById(String itemId) {
		Optional<Item> itemFound = itemRepo.findById( itemId );
		
		return itemFound.isPresent() ? itemFound.get() : new Item();
	}
}
