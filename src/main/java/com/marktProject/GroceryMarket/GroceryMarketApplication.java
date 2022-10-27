package com.marktProject.GroceryMarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.marktProject.GroceryMarket.repository")
@EntityScan("com.marktProject.GroceryMarket.model")
@EnableJpaAuditing(auditorAwareRef = "AuditAwareBean")
public class GroceryMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryMarketApplication.class, args);
	}

}
