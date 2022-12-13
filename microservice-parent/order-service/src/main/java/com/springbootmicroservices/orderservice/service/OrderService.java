package com.springbootmicroservices.orderservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.springbootmicroservices.orderservice.dto.InventoryResponse;
import com.springbootmicroservices.orderservice.dto.OrderLineItemDto;
import com.springbootmicroservices.orderservice.dto.OrderRequest;
import com.springbootmicroservices.orderservice.model.Order;
import com.springbootmicroservices.orderservice.model.OrderLineItems;
import com.springbootmicroservices.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
//@Transactional
public class OrderService {
	private final OrderRepository orderRepository;
	private final WebClient webClient;

@Transactional
 public void placeOrder(OrderRequest orderRequest) {
	 Order order = new Order();
	 order.setOrderNumber(UUID.randomUUID().toString());
	 
	 List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
	 .stream()
	 .map(orderLineItemDto->mapToDto(orderLineItemDto)).toList();
	 order.setOrderLineItems(orderLineItems);
    
	 List<String> skuCodes =order.getOrderLineItems()
			.stream()
			.map(orderLineItem->orderLineItem.getSkuCode()).toList();
	 //Call inventory service and place order if product is available
	 //bodyToMono --> to able to read the response. as we are going to return boolean response
	 // to make synchronous request add .block()
	 InventoryResponse[] inventoryResponseArray = webClient.get()
			 	.uri("http://localhost:8081/api/inventory",uriBuilder->uriBuilder.queryParam("skuCode",skuCodes).build())
			 	.retrieve()
			 	.bodyToMono(InventoryResponse[].class)
			 	.block();

	boolean isProductAvailable = Arrays.stream(inventoryResponseArray).allMatch(inventoryResponse->inventoryResponse.isInStock());
	 if(isProductAvailable)
		 orderRepository.save(order);
	 else
		 throw new IllegalArgumentException("Product is not available, please try again later.");
 }
 
 private OrderLineItems mapToDto(OrderLineItemDto orderLineItemDto) {
	 OrderLineItems orderLineItems = new OrderLineItems();
	 orderLineItems.setId(orderLineItemDto.getId());
	 orderLineItems.setPrice(orderLineItemDto.getPrice());
	 orderLineItems.setQuantity(orderLineItemDto.getQuantity());
	 orderLineItems.setSkuCode(orderLineItemDto.getSkuCode());
	 return orderLineItems;
 }
}
