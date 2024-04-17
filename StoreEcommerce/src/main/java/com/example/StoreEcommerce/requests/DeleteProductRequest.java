package com.example.StoreEcommerce.requests;

import lombok.Data;

@Data
public class DeleteProductRequest {
	Long productId;
	Long userId;
}
