package com.example.StoreEcommerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.StoreEcommerce.entities.Basket;
import com.example.StoreEcommerce.entities.Orders;
import com.example.StoreEcommerce.requests.BasketCreateRequest;
import com.example.StoreEcommerce.requests.OrderCreateRequest;
import com.example.StoreEcommerce.responses.BasketResponse;
import com.example.StoreEcommerce.responses.OrderResponse;
import com.example.StoreEcommerce.services.BasketService;
import com.example.StoreEcommerce.services.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {
private	OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping
	public List<Orders> getAllOrders(@RequestParam(required = false)  Optional<Long> userId){
		return orderService.getAllOrders(userId);
	}
	@GetMapping("/{orderId}")
	public OrderResponse getOneOrderById(@PathVariable Long orderId) {
		return orderService.getOneOrderById(orderId);
	}
	@PostMapping
	public Orders createOneOrder(@RequestBody OrderCreateRequest request) throws Exception {
		return orderService.createOneOrder(request);
	}
	
}
