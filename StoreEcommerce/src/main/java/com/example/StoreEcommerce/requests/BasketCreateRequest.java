package com.example.StoreEcommerce.requests;

import lombok.Data;

@Data
public class BasketCreateRequest {
	Long userId;
	Long productsId;
	Long productsCount;
}
