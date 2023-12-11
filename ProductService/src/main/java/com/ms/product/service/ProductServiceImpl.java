package com.ms.product.service;

import com.ms.product.exception.ResourceNotFoundException;
import com.ms.product.model.Product;
import com.ms.product.payload.Coupon;
import com.ms.product.payload.ProductRequest;
import com.ms.product.repository.ProductRepository;
import com.ms.product.restclients.CouponClient;
import feign.FeignException;
import io.github.resilience4j.retry.annotation.Retry;
import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CouponClient couponClient;

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Override
	@Retry(name = "productService", fallbackMethod = "productServiceFallBack")
	@Observed(
			name = "user.name",
			contextualName = "Product ---> Coupon",
			lowCardinalityKeyValues = {"userType", "userType2"}
	)
	public Product createProduct(ProductRequest product) {

		try {
			Coupon coupon = couponClient.getCouponByCode(product.getCouponCode());
			logger.info("Got Data From Coupon Service");

			Product newProduct = new Product();
			newProduct.setProductName(product.getProductName());
			newProduct.setDescription(product.getDescription());
			newProduct.setProductPrice(product.getProductPrice() - ((coupon.getDiscount() / 100) * product.getProductPrice()));

			return productRepository.save(newProduct);

		} catch (FeignException.NotFound exception) {
			throw new ResourceNotFoundException("Coupon not found by given code " + product.getCouponCode());
		}
	}

	private Product productServiceFallBack(ProductRequest product, Exception exception) {

		if(exception instanceof ResourceNotFoundException) {
			logger.info("Coupon not found by given code: " + exception.getMessage());
			throw new ResourceNotFoundException("Coupon not found by given code " + product.getCouponCode());
		}

		logger.info("Fallback method is executed because service is down: " + exception.getMessage());
		return new Product();
	}
}
