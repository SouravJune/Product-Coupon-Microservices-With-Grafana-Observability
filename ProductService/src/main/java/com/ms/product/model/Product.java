package com.ms.product.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_ms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	
	@Column(name = "Product_Name")
	private String productName;
	
	@Column(name = "Product_Description")
	private String description;
	
	@Column(name = "Price")
	private double productPrice;
}
