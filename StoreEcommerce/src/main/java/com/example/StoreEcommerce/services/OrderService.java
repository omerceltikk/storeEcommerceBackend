package com.example.StoreEcommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.example.StoreEcommerce.entities.Basket;
import com.example.StoreEcommerce.entities.Favorites;
import com.example.StoreEcommerce.entities.Orders;
import com.example.StoreEcommerce.entities.Products;
import com.example.StoreEcommerce.entities.User;
import com.example.StoreEcommerce.repos.BasketRepository;
import com.example.StoreEcommerce.repos.FavoritesRepository;
import com.example.StoreEcommerce.repos.OrderRepository;
import com.example.StoreEcommerce.requests.BasketCreateRequest;
import com.example.StoreEcommerce.requests.FavoritesCreateRequest;
import com.example.StoreEcommerce.requests.OrderCreateRequest;
import com.example.StoreEcommerce.responses.BasketResponse;
import com.example.StoreEcommerce.responses.FavoritesActivityResponse;
import com.example.StoreEcommerce.responses.OrderResponse;


@Service
public class OrderService {
	private OrderRepository orderRepository;
	private UserService userService;
	private ProductService productService;
	public OrderService(OrderRepository orderRepository, UserService userService, ProductService productService) {
		this.orderRepository = orderRepository;
		this.userService = userService;
		this.productService = productService;
	}
	public List<Orders> getAllOrders(Optional<Long> userId) {
		List<Orders> list;
		 if(userId.isPresent()) {
			list = orderRepository.findByUserId(userId.get());
		}
		return orderRepository.findAll();
	}
	public OrderResponse getOneOrderById(Long orderId) {
		Orders currOrder = orderRepository.findById(orderId).orElse(null);
		if(currOrder.getId() != null) {
			OrderResponse orderResponse = new OrderResponse(currOrder);
			return orderResponse;
		}
		return null;
	}
	public Orders createOneOrder(OrderCreateRequest request) throws Exception {
	    User currUser = userService.getUserWithUserId(request.getUserId());
	    if (currUser != null) {
	        Orders createdOrder = new Orders();
	        createdOrder.setUser(currUser);
	        createdOrder.setOrderAddress(request.getOrderAddress());
	        createdOrder.setProducts(request.getProductList());
	        return orderRepository.save(createdOrder);
	    }
	    return null;
	}
	}
	
