package com.example.StoreEcommerce.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StoreEcommerce.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

 User findByUserName(String userName);

//jpaRepository altında findAll methodu select * from table a eşdeğer
	
	
}
