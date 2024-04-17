package com.example.StoreEcommerce.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.StoreEcommerce.entities.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

	//jpa repository ile gelen bir findBy kalıbı ile interfacede istenen bir metod u oluşturup kullanıyoruz.
	//yazdığımız custom findBy kalıbı ile istediğimiz metodu oluşturuyoruz ve gerisini jpa düzenliyor.

}
