package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Product;


//springboot will take care the implementation of this interface 
public interface ProductRepository extends CrudRepository<Product, Integer>{
	
    List<Product> findByName(String name);
	
	List<Product> findByPrice(Double price);
	
	List<Product> findByNameAndPrice(String name, Double price);

}