package com.springbootmicroservices.inventoryservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmicroservices.inventoryservice.dto.InventoryResponse;
import com.springbootmicroservices.inventoryservice.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {
	private final InventoryService inventoryService;
	@GetMapping
	@ResponseStatus(HttpStatus.OK)	
	public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
		return inventoryService.isInStock(skuCode);

	}

}
