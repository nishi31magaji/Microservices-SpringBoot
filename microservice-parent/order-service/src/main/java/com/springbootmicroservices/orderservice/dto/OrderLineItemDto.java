package com.springbootmicroservices.orderservice.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderLineItemDto {
	private Long id;
	private String skuCode;
	private BigDecimal price;
	private Integer quantity;
}
