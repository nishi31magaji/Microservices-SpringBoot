package com.springbootmicroservices.orderservice.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "new_orders")
//@SequenceGenerator(name= "NAME_SEQUENCE", sequenceName = "SEQ_ID", initialValue=1, allocationSize = 1)
public class Order {
	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NAME_SEQUENCE")
	private long id;
	private String orderNumber;
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderLineItems> orderLineItems;

}
