package com.devsuperior.dsecommerce.services.expections;

public class MethodArgumentNotValidExpection extends RuntimeException {
	public MethodArgumentNotValidExpection(String msg) {
		super(msg);
	}

}
