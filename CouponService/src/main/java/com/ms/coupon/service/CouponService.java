package com.ms.coupon.service;

import com.ms.coupon.model.Coupon;

public interface CouponService {

	Coupon addCoupon(Coupon coupon);
	Coupon getCouponByCode(String couponCode);

}
