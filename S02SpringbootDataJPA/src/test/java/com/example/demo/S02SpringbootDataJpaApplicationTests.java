package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@SpringBootTest
class S02SpringbootDataJpaApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() {
	}

	@Test
	void saveProduct() {
		ProductRepository repo = context.getBean(ProductRepository.class);//get the context by autowire
		//from the context,it get the bean of product repository

		Product product = new Product();
		product.setName("Laptop");
		product.setDescription("Hp with 8gb ram");
		product.setPrice(10000);

		repo.save(product);
	}

	@Test
	void readProduct() {
		ProductRepository repo = context.getBean(ProductRepository.class);

		Optional<Product> optionalProduct = repo.findById(13);//optional product means whether it may be available in context or not
		//if id is not present,it return null ,you can see it by debug mode
		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			System.out.println(product);
		}
	}

	@Test
	void deleteProduct() {
		ProductRepository repo = context.getBean(ProductRepository.class);

		repo.deleteById(4);
		repo.deleteById(5);
	}

	@Test
	void findByName() {
		ProductRepository repo = context.getBean(ProductRepository.class);

		List<Product> products = repo.findByName("headset");
		System.out.println(products);
	}
	
	@Test
	void updateProduct() {
		ProductRepository repo = context.getBean(ProductRepository.class);
		
		Optional<Product> optionalProduct = repo.findById(1);
		Product product = null;
		if (optionalProduct.isPresent()) {
			product = optionalProduct.get();
			System.out.println(product);
		}
		if (product != null) {
			product.setPrice(12123);
			repo.save(product);
		}
	}

}