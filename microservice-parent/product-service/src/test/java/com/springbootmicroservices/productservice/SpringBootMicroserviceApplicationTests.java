package com.springbootmicroservices.productservice;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@Testcontainers
class SpringBootMicroserviceApplicationTests {	
	
	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("spring.data.mongodb.url", mongoDBContainer::getReplicaSetUrl);
	}
	@Test
	void contextLoads() {
	}
	/*
	 * @Test void shouldCratedProduct() throws Exception {
	 * mockMvc.perform(MockMvcRequestBuilders.post("api/product")
	 * .contentType(MediaType.APPLICATION_JSON) .content(); }
	 */
	/*
	 * private ProductRequest getProductRequest() { return ProductRequest.builder()
	 * .name("iphone 13") .description("iphone 13") .price(BigDecimal.valueOf(1200))
	 * .build(); }
	 */
}
