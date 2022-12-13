package com.springbootmicroservices.inventoryservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="t_inventory")
@Data
@SequenceGenerator(name= "NAME_SEQUENCE_INVENTORY", sequenceName = "SEQ_ID_INVENTORY", initialValue=1, allocationSize = 1)
public class Inventory {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NAME_SEQUENCE_INVENTORY")
	private Long id;
	private String skuCode;
	private Integer quantity;
}
