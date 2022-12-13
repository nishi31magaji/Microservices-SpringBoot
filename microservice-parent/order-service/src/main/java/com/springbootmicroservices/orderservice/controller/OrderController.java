package com.springbootmicroservices.orderservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmicroservices.orderservice.dto.OrderRequest;
import com.springbootmicroservices.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
//@RequiredArgsConstructor added so that intialization is not required for orderService
	private final OrderService orderService;
@PostMapping
@Transactional
@ResponseStatus(HttpStatus.CREATED)
 public String placeOrder(@RequestBody OrderRequest orderRequest) {	
	 orderService.placeOrder(orderRequest);
	 return "Order placed successfully";
 }
}
