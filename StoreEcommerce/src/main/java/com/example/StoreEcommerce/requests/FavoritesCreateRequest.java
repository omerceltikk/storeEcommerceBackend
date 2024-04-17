package com.example.StoreEcommerce.requests;

import lombok.Data;

@Data
public class FavoritesCreateRequest {
	Long userId;
	Long productsId;
}
