package com.springbootmicroservices.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootmicroservices.productservice.dto.ProductReqeust;
import com.springbootmicroservices.productservice.dto.ProductResponseDTO;
import com.springbootmicroservices.productservice.model.Product;
import com.springbootmicroservices.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepository productRepository;
	private ProductResponseDTO productResponseDTO;
	
	public void createProduct(ProductReqeust productReqeust) {
		Product product = Product.builder()
				.name(productReqeust.getName())
				.description(productReqeust.getDescription())
				.price(productReqeust.getPrice())
				.build();
		
		productRepository.save(product);
		log.info("Product {} is saved",product.getId());
				
	}
	
	public List<ProductResponseDTO> getAllProducts(){
		List<Product>products=productRepository.findAll();
		return products.stream().map(product->mapToProductResponse(product)).toList();
	}
	private ProductResponseDTO mapToProductResponse(Product product) {
		return ProductResponseDTO.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
		
	}
}
