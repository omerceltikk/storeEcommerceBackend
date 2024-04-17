package com.example.StoreEcommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "StoreCategory")
@Data 
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // oto create id
	 Long id;
	
	String categoryGender;
	String upperCategory;
	String category;
	String categoryTr;
}
