package com.example.StoreEcommerce.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.StoreEcommerce.entities.Favorites;


public interface FavoritesRepository extends JpaRepository<Favorites,Long> {

	List<Favorites> findByUserId(Long userId);
	
	
	@Query(value="select * from dbo.demov5like where post_id in :productIds", nativeQuery=true)
	List<Favorites> findUserLikesByPostId(@Param("productIds") List<Long> productIds);


}
