package com.ms.coupon.service;

import com.ms.coupon.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.coupon.Repository.CouponRepository;
import com.ms.coupon.model.Coupon;

@Service
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	private CouponRepository couponRepository;

	@Override
	public Coupon addCoupon(Coupon coupon) {
		return couponRepository.save(coupon);
	}

	@Override
	public Coupon getCouponByCode(String couponCode) {
		return couponRepository.findByCouponCode(couponCode)
				.orElseThrow(() -> new ResourceNotFoundException("Coupon not found by given code " + couponCode));
	}

}
