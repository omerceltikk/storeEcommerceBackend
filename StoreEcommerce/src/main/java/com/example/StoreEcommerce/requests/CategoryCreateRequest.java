package com.example.StoreEcommerce.requests;

import lombok.Data;

@Data
public class CategoryCreateRequest {
	String categoryGender;
	String category;
	String categoryTr;
	String upperCategory;
	Long userId;
}
