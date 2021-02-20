package com.microservices.shoppingcartservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.shoppingcartservice.itemservice.ItemService;
import com.microservices.shoppingcartservice.model.Item;

@RestController
@RequestMapping("/carts/{customerId}/items")
public class ItemsController {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
    private CartsController cartsController;
	
    @GetMapping(value = "/{itemId:.*}", produces = MediaType.APPLICATION_JSON_VALUE )
    public Item get(@PathVariable String customerId, @PathVariable String itemId) {
//        return new FoundItem(() -> getItems(customerId), () -> new Item(itemId)).get();
    	Item itemFound = itemService.getItemById( String.valueOf( itemId ) );
    	return itemFound;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE )
    public List<Item> getItems(@PathVariable String customerId) {
//        return cartsController.get(customerId);
    	return new ArrayList<Item>();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE )
    public Item addToCart(@PathVariable String customerId, @RequestBody Item item) {
        // If the item does not exist in the cart, create new one in the repository.
		/*
		 * FoundItem foundItem = new FoundItem(() ->
		 * cartsController.get(customerId).contents(), () -> item); if
		 * (!foundItem.hasItem()) { Supplier<Item> newItem = new ItemResource(itemDAO,
		 * () -> item).create(); LOG.debug("Did not find item. Creating item for user: "
		 * + customerId + ", " + newItem.get()); new CartResource(cartDAO,
		 * customerId).contents().get().add(newItem).run(); return item; } else { Item
		 * newItem = new Item(foundItem.get(), foundItem.get().quantity() + 1);
		 * LOG.debug("Found item in cart. Incrementing for user: " + customerId + ", " +
		 * newItem); updateItem(customerId, newItem); return newItem; }
		 */
    	return item;
    }

    @DeleteMapping(value = "/{itemId:.*}" )
    public void removeItem(@PathVariable String customerId, @PathVariable String itemId) {
		/*
		 * FoundItem foundItem = new FoundItem(() -> getItems(customerId), () -> new
		 * Item(itemId)); Item item = foundItem.get();
		 * 
		 * LOG.debug("Removing item from cart: " + item); new CartResource(cartDAO,
		 * customerId).contents().get().delete(() -> item).run();
		 * 
		 * LOG.debug("Removing item from repository: " + item); new
		 * ItemResource(itemDAO, () -> item).destroy().run();
		 */
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PATCH)
    public void updateItem(@PathVariable String customerId, @RequestBody Item item) {
        // Merge old and new items
		/*
		 * ItemResource itemResource = new ItemResource(itemDAO, () -> get(customerId,
		 * item.itemId())); LOG.debug("Merging item in cart for user: " + customerId +
		 * ", " + item); itemResource.merge(item).run();
		 */
    }

    @PostMapping(value = "/createitem" ,consumes =  MediaType.APPLICATION_JSON_VALUE )
    public Item createItem(@PathVariable String customerId, @RequestBody Item item) {
    	itemService.createItem(item);
    	return item;
    }
}
