package com.example.StoreEcommerce.responses;


import com.example.StoreEcommerce.entities.Basket;
import com.example.StoreEcommerce.entities.Favorites;
import com.example.StoreEcommerce.entities.Products;

import lombok.Data;

@Data
public class BasketResponse {
	Long basketId;
	Long userId;
	Long productId;
	String productName;
	Long productPrice;
	Long productCount;
	Long productStockCount;
	String productUrl;
	//response needs will be added here and favorites
	public BasketResponse(Basket entity) {
		this.basketId = entity.getId();
		this.userId = entity.getUser().getId();
		this.productId = entity.getProducts().getId();
		this.productName = entity.getProducts().getProductName();
		this.productPrice = entity.getProducts().getDiscountPrice();
		this.productStockCount = entity.getProducts().getProductStockCount();
		this.productCount = entity.getProductCount();
		this.productUrl = entity.getProducts().getProductUrl();
		}
}
