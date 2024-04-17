package com.example.StoreEcommerce.requests;

import lombok.Data;

@Data
public class RefreshRequest {
	Long userId;
	String RefreshToken;
}
