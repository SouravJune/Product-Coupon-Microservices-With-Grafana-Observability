package com.ms.product.payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {

	private long couponId;
	private String couponCode;
	private double discount;
	private String expDate;
}
