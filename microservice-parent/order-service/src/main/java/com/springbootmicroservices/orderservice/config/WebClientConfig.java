package com.springbootmicroservices.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	//whenver we add bean annotation this bean will be created with the method name
@Bean
public WebClient webClient() {
	return WebClient.builder().build();
}
}
