package com.ms.product.restclients;

import com.ms.product.payload.Coupon;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "API-GATEWAY")
@RibbonClient(name = "COUPON-SERVICE")
public interface CouponClient {

    @GetMapping("/couponapi/coupons/{couponCode}")
    Coupon getCouponByCode(@PathVariable String couponCode);
}
