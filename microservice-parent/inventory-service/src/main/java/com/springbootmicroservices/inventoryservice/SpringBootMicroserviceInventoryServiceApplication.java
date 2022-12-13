package com.springbootmicroservices.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootmicroservices.inventoryservice.model.Inventory;
import com.springbootmicroservices.inventoryservice.repository.InventoryRepository;

@SpringBootApplication
public class SpringBootMicroserviceInventoryServiceApplication {

	public static void main(String[] args) {
	SpringApplication.run(SpringBootMicroserviceInventoryServiceApplication.class, args);
		
	}
	// this bean is created at application startup
	/*
	 * @Bean public CommandLineRunner loadData(InventoryRepository
	 * inventoryRepository) { return args -> { Inventory inventory1 = new
	 * Inventory(); inventory1.setSkuCode("iphone_14"); inventory1.setQuantity(100);
	 * 
	 * Inventory inventory2 = new Inventory();
	 * inventory2.setSkuCode("oneplus_nord2"); inventory2.setQuantity(0);
	 * 
	 * inventoryRepository.save(inventory1); inventoryRepository.save(inventory2);
	 * }; }
	 */

}
