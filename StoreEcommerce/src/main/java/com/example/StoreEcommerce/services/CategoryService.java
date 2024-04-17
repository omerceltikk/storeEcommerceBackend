package com.example.StoreEcommerce.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.StoreEcommerce.entities.Category;
import com.example.StoreEcommerce.entities.Favorites;
import com.example.StoreEcommerce.entities.Products;
import com.example.StoreEcommerce.entities.User;
import com.example.StoreEcommerce.repos.CategoryRepository;
import com.example.StoreEcommerce.repos.FavoritesRepository;
import com.example.StoreEcommerce.requests.CategoryCreateRequest;
import com.example.StoreEcommerce.requests.FavoritesCreateRequest;
import com.example.StoreEcommerce.responses.FavoritesActivityResponse;



@Service

public class CategoryService {
	private CategoryRepository categoryRepo;
	private UserService userService;
	private ProductService productService;
	public CategoryService(CategoryRepository categoryRepo, UserService userService, ProductService productService) {
		this.categoryRepo = categoryRepo;
		this.userService = userService;
		this.productService = productService;
	}
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}
	public Category getOneCategoryById(Long categoryId) {
		return categoryRepo.findById(categoryId).orElse(null);
	}
	public Category createOneCategory(CategoryCreateRequest request) {
		User currUser = userService.getUserWithUserId(request.getUserId());
//		if(currUser != null && currUser.getUserStatus() == "admin") {
		Category createdCategory = new Category();
			createdCategory.setCategory(request.getCategory());
			createdCategory.setCategoryGender(request.getCategoryGender());
			createdCategory.setCategoryTr(request.getCategoryTr());
			createdCategory.setUpperCategory(request.getUpperCategory());
			return categoryRepo.save(createdCategory);
//		}
//		return null;
	
	}
	public void deleteOneCategory(Long categoryId) {
		categoryRepo.deleteById(categoryId);
	}
}
