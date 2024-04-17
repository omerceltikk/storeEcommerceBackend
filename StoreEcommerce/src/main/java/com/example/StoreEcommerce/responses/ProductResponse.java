package com.example.StoreEcommerce.responses;

import java.util.List;

import com.example.StoreEcommerce.entities.Products;


import lombok.Data;

@Data
public class ProductResponse {
	Long productId;
	String productName;
	String productDescription;
	String productUrl;
	Long productStockCount;
	Long productPrice;
	Long discountPercent;
	Long discountPrice;
	List<ImageResponse> images;
	Long categoryId;
	String primeCategory;

	public ProductResponse(Products entity, List<ImageResponse> images) {
		this.productId = entity.getId();
		this.productName = entity.getProductName();
		this.productDescription = entity.getProductDescription();
		this.productUrl = entity.getProductUrl();
		this.productStockCount = entity.getProductStockCount();
		this.productPrice = entity.getProductPrice();
		this.discountPercent = entity.getDiscountPercent();
		this.discountPrice = entity.getDiscountPrice();
		this.categoryId = entity.getCategory().getId();
		this.primeCategory = entity.getCategory().getCategoryGender();
		this.images =images;
	}
}
