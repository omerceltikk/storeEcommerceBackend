package com.example.StoreEcommerce.responses;

import java.util.Date;
import java.util.List;

import com.example.StoreEcommerce.entities.Favorites;
import com.example.StoreEcommerce.entities.Orders;

import lombok.Data;

@Data
public class OrderResponse {
	Long orderId;
	Long userId;
	String productList;
	Date date;
	
	public OrderResponse(Orders entity) {
		this.orderId = entity.getId();
		this.userId = entity.getUser().getId();
		this.productList = entity.getProducts();
		this.date = entity.getCreateDate(); 
	
	}
}
