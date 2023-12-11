package com.ms.coupon.controller;

import com.ms.coupon.model.Coupon;
import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.coupon.service.CouponService;

@RestController
@RequestMapping("/couponapi")
@Observed(name = "user.name")
public class CouponController {

	@Autowired
	private CouponService couponService;

	private static final Logger logger = LoggerFactory.getLogger(CouponController.class);

	@PostMapping("/coupons")
	public ResponseEntity<Coupon> createNewCoupon(@RequestBody Coupon coupon){
		return ResponseEntity.status(HttpStatus.CREATED).body(couponService.addCoupon(coupon));
	}
	
	@GetMapping("/coupons/{couponCode}")
	public ResponseEntity<Coupon> getCouponByCode(@PathVariable String couponCode) {
		return ResponseEntity.status(HttpStatus.OK).body(couponService.getCouponByCode(couponCode));
	}
	
}
