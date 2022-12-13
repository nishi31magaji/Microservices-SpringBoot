package com.springbootmicroservices.orderservice.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="new_order_line_itmes")
//@SequenceGenerator(name= "NAME_SEQUENCE", sequenceName = "SEQ_ID", initialValue=1, allocationSize = 1)
public class OrderLineItems {
	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NAME_SEQUENCE")
	private Long id;
	private String skuCode;
	private BigDecimal price;
	private Integer quantity;
}
