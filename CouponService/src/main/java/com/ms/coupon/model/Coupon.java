package com.ms.coupon.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "coupon_ms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long couponId;
	
	@Column(name = "Coupon_Code")
	private String couponCode;
	
	private double discount;
	private String expDate;
}
