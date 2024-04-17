package com.example.StoreEcommerce.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.example.StoreEcommerce.entities.Basket;
import com.example.StoreEcommerce.entities.Favorites;
import com.example.StoreEcommerce.entities.Products;
import com.example.StoreEcommerce.entities.User;
import com.example.StoreEcommerce.repos.BasketRepository;
import com.example.StoreEcommerce.repos.FavoritesRepository;
import com.example.StoreEcommerce.requests.BasketCreateRequest;
import com.example.StoreEcommerce.requests.FavoritesCreateRequest;
import com.example.StoreEcommerce.responses.BasketResponse;
import com.example.StoreEcommerce.responses.FavoritesActivityResponse;


@Service
public class BasketService {
	private BasketRepository basketRepository;
	private UserService userService;
	private ProductService productService;
	public BasketService(BasketRepository basketRepository, UserService userService, ProductService productService) {
		this.basketRepository = basketRepository;
		this.userService = userService;
		this.productService = productService;
	}
	public List<BasketResponse> getAllBasket(Optional<Long> userId) {
		List<Basket> list;
		 if(userId.isPresent()) {
			list = basketRepository.findByUserId(userId.get());
		}
		list = basketRepository.findAll();
		 return list.stream().map((l) -> new BasketResponse(l)).collect(Collectors.toList());
		
	}
	public Basket getOneBasketById(Long basketId) {
		Basket currBasket = basketRepository.findById(basketId).orElse(null);
		if(currBasket.getId() != null) {
			return currBasket;
		}
		return null;
	}
	public Basket createOneBasket(BasketCreateRequest request) throws Exception{
		Products currProduct = productService.getOneProductById(request.getProductsId());
		User currUser = userService.getUserWithUserId(request.getUserId());
		if(currUser != null && currProduct != null && request.getProductsCount() > 0 && request.getProductsCount() <= currProduct.getProductStockCount()) {
			Basket createdBasket = new Basket();
			createdBasket.setUser(currUser);
			createdBasket.setProducts(currProduct);
			createdBasket.setProductCount(request.getProductsCount());
			return basketRepository.save(createdBasket);
		}
		if(request.getProductsCount() <= currProduct.getProductStockCount()) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}
		return null;
	
	}
	
	public Basket updateBasket(Long basketId, BasketCreateRequest basketCreateRequest) {
		Basket currBasket = basketRepository.findById(basketId).orElse(null);	
		Long stockCount = productService.getOneProductById(currBasket.getProducts().getId()).getProductStockCount();
		if(stockCount < currBasket.getProductCount()) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}
		currBasket.setProductCount(basketCreateRequest.getProductsCount());
		return basketRepository.save(currBasket);
	}
	
	public void deleteOneBasket(Long favoriteId) {
		basketRepository.deleteById(favoriteId);
	}
}
