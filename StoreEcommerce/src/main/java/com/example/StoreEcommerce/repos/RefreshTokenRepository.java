package com.example.StoreEcommerce.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StoreEcommerce.entities.RefreshToken;



public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{

	RefreshToken findByUserId(Long userId);
	
}