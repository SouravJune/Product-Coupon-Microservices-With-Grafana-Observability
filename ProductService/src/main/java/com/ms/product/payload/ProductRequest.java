package com.ms.product.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

	private long productId;
	private String productName;
	private String description;
	private double productPrice;
	private String couponCode;
}
