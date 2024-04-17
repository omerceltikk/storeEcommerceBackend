package com.example.StoreEcommerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.StoreEcommerce.entities.Products;
import com.example.StoreEcommerce.requests.BuyingProductUpdateRequest;
import com.example.StoreEcommerce.requests.DeleteProductRequest;
import com.example.StoreEcommerce.requests.ProductCreateRequest;
import com.example.StoreEcommerce.responses.ProductResponse;
import com.example.StoreEcommerce.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	@GetMapping
	public List<ProductResponse> getAllPosts() {
		return productService.getAllProducts();
	}
	@GetMapping("/{productsId}")
	public Products getOneProduct(@PathVariable Long productsId) {
		return productService.getOneProductById(productsId);
	}
	@PostMapping
	public Products createProduct(@RequestBody ProductCreateRequest newPostRequest) throws Exception {
		return productService.createProduct(newPostRequest);
	}
	@PutMapping("/{productsId}")
	public Products updateProduct (@PathVariable Long productsId, @RequestBody BuyingProductUpdateRequest buyingProductUpdateRequest) throws Exception {
		return productService.updateProduct(productsId,buyingProductUpdateRequest);
	}
	@DeleteMapping("/{prodcutsId}")
	public void deletePproduct (@PathVariable Integer productsId ,@RequestBody DeleteProductRequest deleteProductRequest ) throws Exception {
		productService.deletePost(productsId,deleteProductRequest);
	}

	
}