package com.example.StoreEcommerce.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.StoreEcommerce.entities.Favorites;
import com.example.StoreEcommerce.entities.Products;
import com.example.StoreEcommerce.entities.User;
import com.example.StoreEcommerce.repos.FavoritesRepository;
import com.example.StoreEcommerce.requests.FavoritesCreateRequest;
import com.example.StoreEcommerce.responses.FavoritesActivityResponse;



@Service

public class FavoritesService {
	private FavoritesRepository favoritesRepo;
	private UserService userService;
	private ProductService productService;
	public FavoritesService(FavoritesRepository favoritesRepo, UserService userService, ProductService productService) {
		this.favoritesRepo = favoritesRepo;
		this.userService = userService;
		this.productService = productService;
	}
	public List<FavoritesActivityResponse> getAllFavorites(Optional<Long> userId) {
		List<Favorites> list;
		
		 if(userId.isPresent()) {
			list = favoritesRepo.findByUserId(userId.get());
		}
		
		list = favoritesRepo.findAll();
		 return list.stream().map((l) -> new FavoritesActivityResponse(l)).collect(Collectors.toList());
		
	}
	public Favorites getOneFavoritesById(Long favoritesId) {
		return favoritesRepo.findById(favoritesId).orElse(null);
	}
	public Favorites createOneFavorites(FavoritesCreateRequest request) {
		Products currProduct = productService.getOneProductById(request.getProductsId());
		User currUser = userService.getUserWithUserId(request.getUserId());
		if(currUser != null && currProduct != null) {
			Favorites createdFav = new Favorites();
			createdFav.setUser(currUser);
			createdFav.setProducts(currProduct);
			return favoritesRepo.save(createdFav);
		}
		return null;
	
	}
	public void deleteOneFavorites(Long favoriteId) {
		favoritesRepo.deleteById(favoriteId);
	}
}
