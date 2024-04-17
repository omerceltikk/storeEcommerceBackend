package com.example.StoreEcommerce.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.StoreEcommerce.entities.Images;

public interface ImageRepository extends JpaRepository<Images,Long> {

//	List<Images> findByUserIdAndPostId(Integer userId, Integer postId);

//	List<Images> findByUserId(Integer userId);

//	List<Images> findByPostId(Integer postId);
	
	List<Images> findByProductsId(Long productsId);
	
//	@Query(value="select * from dbo.demov5like where post_id in :postIds", nativeQuery=true)
//	List<Images> findUserLikesByPostId(@Param("postIds") List<Integer> postIds);

}
