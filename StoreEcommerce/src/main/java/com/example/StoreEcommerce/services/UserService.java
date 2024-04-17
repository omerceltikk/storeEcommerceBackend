package com.example.StoreEcommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.StoreEcommerce.entities.User;
import com.example.StoreEcommerce.repos.UserRepository;



@Service
public class UserService {
	private UserRepository userRepo; //spring boot otomatik olarak repository i inject eder. bu injectler içerisinden constructor injection'ı tercih ettik.
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	

	public List<User> getAllUsers() {
		return userRepo.findAll();	
	}
	public User getUserWithUserId(Long userId) {
		//path varible annotation u ile gelen id yi getmapping pathine yönlendirdik
		// dbde olmayan user için exception eklenecek
		return userRepo.findById(userId).orElse(null);
	}

	public User createUser(User newUser) {
		return userRepo.save(newUser);
	}
	
	public User updateUser(Long userId,User newUser) {
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent()) {
			User updatedUser = new User();
			updatedUser.setId(newUser.getId());
			updatedUser.setPassword(newUser.getPassword());
			updatedUser.setUserName(newUser.getUserName());
			return updatedUser;
		}else {
			return null;
		}
	}
	public void DeleteUser(Long id) {
		userRepo.deleteById(id);
	}

	public User getUserWithUsername(String username) {
		return userRepo.findByUserName(username);
	}

}
