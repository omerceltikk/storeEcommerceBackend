package com.example.StoreEcommerce.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StoreEcommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
