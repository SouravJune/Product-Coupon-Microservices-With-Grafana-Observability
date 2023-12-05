package com.ms.coupon.Repository;

import com.ms.coupon.model.Coupon;
import io.micrometer.observation.annotation.Observed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

	Optional<Coupon> findByCouponCode(String couponCode);

}
