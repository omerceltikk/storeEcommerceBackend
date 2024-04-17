package com.example.StoreEcommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "StoreUsers")
@Data //lombok ile otomatik olarak getter setter generate etmek için eklendi.
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // oto create id
	 Long id;
	
	 String userName;
	 String password;
	 String userStatus;
}