package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication(scanBasePackages = "com")
@EntityScan("com.model")
@EnableJpaRepositories("com.repository")
public class AadharWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(AadharWebsiteApplication.class, args);
	}

}
