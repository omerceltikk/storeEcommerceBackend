package com.example.StoreEcommerce.requests;

import java.util.ArrayList;
import java.util.List;


import lombok.Data;
 
@Data

public class OrderCreateRequest {
	Long userId;
	String orderAddress;
	String productList;
}
