package com.example.StoreEcommerce.entities;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "StoreOrders3")
@Data 
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // oto create id
	Long id;
	
	@ManyToOne(fetch = FetchType.EAGER) //hibernate üzerinde one to one many to one gibi bir çok ilişki kurabiliriz.
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	User user;
	
	String products;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date createDate;
	
	String orderAddress;
	
}
