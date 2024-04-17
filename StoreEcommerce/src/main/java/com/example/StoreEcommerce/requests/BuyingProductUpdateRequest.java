package com.example.StoreEcommerce.requests;

import java.util.List;

import com.example.StoreEcommerce.entities.Category;
import com.example.StoreEcommerce.entities.Images;

import lombok.Data;

@Data

public class BuyingProductUpdateRequest {
	Long userId;

	Long buyingCount;
	String productId;
}
