package com.example.StoreEcommerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StoreEcommerce.entities.Basket;
import com.example.StoreEcommerce.entities.Favorites;
import com.example.StoreEcommerce.entities.Products;
import com.example.StoreEcommerce.requests.BasketCreateRequest;
import com.example.StoreEcommerce.requests.BuyingProductUpdateRequest;
import com.example.StoreEcommerce.requests.FavoritesCreateRequest;
import com.example.StoreEcommerce.responses.BasketResponse;
import com.example.StoreEcommerce.responses.FavoritesActivityResponse;
import com.example.StoreEcommerce.services.BasketService;
import com.example.StoreEcommerce.services.FavoritesService;


@RestController
@RequestMapping("/basket")
public class BasketController {
private	BasketService basketService;
	
	public BasketController(BasketService basketService) {
		this.basketService = basketService;
	}
	
	@GetMapping
	public List<BasketResponse> getAllBasket(Optional<Long> userId){
		return basketService.getAllBasket(userId);
	}
	@GetMapping("/{basketId}")
	public Basket getOneBasketById(@PathVariable Long basketId) {
		return basketService.getOneBasketById(basketId);
	}
	@PostMapping
	public Basket createOneBasket(@RequestBody BasketCreateRequest request) throws Exception {
		return basketService.createOneBasket(request);
	}
	@PutMapping("/{basketId}")
	public Basket updateBasket (@PathVariable Long basketId, @RequestBody BasketCreateRequest basketCreateRequest) throws Exception {
		return basketService.updateBasket(basketId,basketCreateRequest);
	}
	@DeleteMapping("/{basketId}")
	public void deleteOneFavorites(@PathVariable Long basketId) {
		basketService.deleteOneBasket(basketId);
	}
}
