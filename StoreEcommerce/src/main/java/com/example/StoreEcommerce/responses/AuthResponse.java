package com.example.StoreEcommerce.responses;

import lombok.Data;

@Data
public class AuthResponse {
	Long userId;
	String message;
	String userName;
	String accessToken;
	String refreshToken;
	String userStatus;
}
