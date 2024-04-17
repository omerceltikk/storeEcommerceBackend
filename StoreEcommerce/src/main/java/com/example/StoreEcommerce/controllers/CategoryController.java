package com.example.StoreEcommerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.StoreEcommerce.entities.Category;
import com.example.StoreEcommerce.entities.Favorites;
import com.example.StoreEcommerce.requests.CategoryCreateRequest;
import com.example.StoreEcommerce.requests.FavoritesCreateRequest;
import com.example.StoreEcommerce.responses.FavoritesActivityResponse;
import com.example.StoreEcommerce.services.CategoryService;
import com.example.StoreEcommerce.services.FavoritesService;


@RestController
@RequestMapping("/categories")
public class CategoryController {
private	CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public List<Category> getAllFavorites(Optional<Long> userId){
		return categoryService.getAllCategories();
	}
	@GetMapping("/{categoryId}")
	public Category getOneCategoryById(@PathVariable Long categoryId) {
		return categoryService.getOneCategoryById(categoryId);
	}
	@PostMapping
	public Category createOneCategory(@RequestBody CategoryCreateRequest request) {
		return categoryService.createOneCategory(request);
	}
	@DeleteMapping("/{categoryId}")
	public void deleteOneFavorites(@PathVariable Long categoryId) {
		categoryService.deleteOneCategory(categoryId);
	}
}
