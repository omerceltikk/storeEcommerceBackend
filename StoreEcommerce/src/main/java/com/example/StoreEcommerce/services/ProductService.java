
package com.example.StoreEcommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.example.StoreEcommerce.entities.Images;
import com.example.StoreEcommerce.entities.Products;
import com.example.StoreEcommerce.entities.User;
import com.example.StoreEcommerce.repos.CategoryRepository;
import com.example.StoreEcommerce.repos.ImageRepository;
import com.example.StoreEcommerce.repos.ProductRepository;
import com.example.StoreEcommerce.requests.BuyingProductUpdateRequest;
import com.example.StoreEcommerce.requests.DeleteProductRequest;
import com.example.StoreEcommerce.requests.ProductCreateRequest;
import com.example.StoreEcommerce.responses.ImageResponse;
import com.example.StoreEcommerce.responses.ProductResponse;


@Service
public class ProductService {
	private ProductRepository productRepository; //spring boot otomatik olarak repository i inject eder. bu injectler içerisinden constructor injection'ı tercih ettik.
	private ImageRepository imageRepo;
	private UserService userService;
	private CategoryRepository categoryRepo;
	
	public ProductService(ProductRepository productRepository, UserService userService,ImageRepository imageRepo,CategoryRepository categoryRepo) {
		this.productRepository = productRepository;
		this.imageRepo = imageRepo;
		this.userService = userService;
		this.categoryRepo = categoryRepo;
	}
	
	
	public List<ProductResponse> getAllProducts() {
		List<Products> list;
		list = productRepository.findAll();	
		return list.stream().map(p -> {
			List<ImageResponse> images = imageRepo.findByProductsId(p.getId()).stream().map((l) -> new ImageResponse(l)).collect(Collectors.toList());
			return new ProductResponse(p, images);
		}).collect(Collectors.toList());
	}

	public Products getOneProductById(Long productsId) {
		// exception handle!!
		return productRepository.findById(productsId).orElse(null);
	}

	public Products createProduct(ProductCreateRequest newPostRequest) throws Exception {
		User user= userService.getUserWithUserId(newPostRequest.getUserId());
			if(user.getUserStatus() != "admin") {
				throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
			}
		Products toSave = new Products();
		toSave.setProductName(newPostRequest.getProductName());
		toSave.setProductDescription(newPostRequest.getProductDescription());
		toSave.setProductPrice(newPostRequest.getProductPrice());
		toSave.setDiscountPercent(newPostRequest.getDiscountPercent());
		toSave.setDiscountPrice(newPostRequest.getDiscountPrice());
		toSave.setProductStockCount(newPostRequest.getProductStockCount());
		toSave.setProductUrl(newPostRequest.getProductUrl());
		toSave.setCategory(categoryRepo.findById(newPostRequest.getCategoryId()).orElse(null));
		if(newPostRequest.getProductImageUrls().size() != 0) {
			for(String  imageUrl : newPostRequest.getProductImageUrls()) {
				Images toSaveImage = new Images();
				toSaveImage.setImageUrl(imageUrl);
				toSaveImage.setProducts(toSave);
				imageRepo.save(toSaveImage);
			}
		}
		return productRepository.save(toSave);
	}


	public Products updateProduct(Long productsId,BuyingProductUpdateRequest buyingProductUpdateRequest) throws Exception {
		Products product = productRepository.findById(productsId).orElse(null);
		if(product.getProductStockCount() < buyingProductUpdateRequest.getBuyingCount()) {	
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}else {
		product.setId(product.getId());
		product.setProductStockCount(product.getProductStockCount() - buyingProductUpdateRequest.getBuyingCount());	
		return productRepository.save(product);
		}
	}
	
	public void deletePost(Integer productsId , DeleteProductRequest deleteProductRequest ) throws Exception {
		User user= userService.getUserWithUserId(deleteProductRequest.getUserId());
		if(user.getUserStatus() != "admin") {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}
		productRepository.deleteById(deleteProductRequest.getProductId());
	}
	
}
