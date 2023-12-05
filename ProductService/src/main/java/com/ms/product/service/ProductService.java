package com.ms.product.service;

import com.ms.product.model.Product;
import com.ms.product.payload.ProductRequest;

public interface ProductService {

	Product createProduct(ProductRequest product);

}
