package com.example.StoreEcommerce.responses;


import com.example.StoreEcommerce.entities.Favorites;

import lombok.Data;

@Data
public class FavoritesActivityResponse {
	String message = "liked";
	Long favoritesId;
	Long productId;
	Long userId;
	String productName;
	Long productPrice;
	String imageUrl;
	public FavoritesActivityResponse(Favorites entity) {
		this.favoritesId = entity.getId();
		this.productId = entity.getProducts().getId();
		this.userId = entity.getUser().getId();
		this.productName = entity.getProducts().getProductName();
		this.productPrice = entity.getProducts().getDiscountPrice();
		this.imageUrl = entity.getProducts().getProductUrl();
	}
}
