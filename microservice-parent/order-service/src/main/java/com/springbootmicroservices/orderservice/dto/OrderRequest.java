package com.springbootmicroservices.orderservice.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderRequest {
	private long id;
	private List<OrderLineItemDto>orderLineItemsDtoList;
}
