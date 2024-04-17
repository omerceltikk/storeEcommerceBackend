package com.example.StoreEcommerce.requests;

import java.util.List;

import com.example.StoreEcommerce.entities.Category;
import com.example.StoreEcommerce.entities.Images;

import lombok.Data;

@Data

public class ProductCreateRequest {
	Long userId;
	String productName;
	String productDescription;
	String productUrl;
	Long productStockCount;
	Long productPrice;
	Long discountPercent;
	Long discountPrice;
	Long categoryId;
	List<String> productImageUrls;
}
