package com.ms.product.exception;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException() {
		super("Resource not found on database");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
