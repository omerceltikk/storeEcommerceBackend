package com.example.StoreEcommerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.StoreEcommerce.entities.Favorites;
import com.example.StoreEcommerce.requests.FavoritesCreateRequest;
import com.example.StoreEcommerce.responses.FavoritesActivityResponse;
import com.example.StoreEcommerce.services.FavoritesService;


@RestController
@RequestMapping("/favorites")
public class FavoritesController {
private	FavoritesService favoritesService;
	
	public FavoritesController(FavoritesService favoritesService) {
		this.favoritesService = favoritesService;
	}
	
	@GetMapping
	public List<FavoritesActivityResponse> getAllFavorites(Optional<Long> userId){
		return favoritesService.getAllFavorites(userId);
	}
	@GetMapping("/{favoritesId}")
	public Favorites getOneFavoritesById(@PathVariable Long favoritesId) {
		return favoritesService.getOneFavoritesById(favoritesId);
	}
	@PostMapping
	public Favorites createOneFavorites(@RequestBody FavoritesCreateRequest request) {
		return favoritesService.createOneFavorites(request);
	}
	@DeleteMapping("/{favoritesId}")
	public void deleteOneFavorites(@PathVariable Long favoritesId) {
		favoritesService.deleteOneFavorites(favoritesId);
	}
}
