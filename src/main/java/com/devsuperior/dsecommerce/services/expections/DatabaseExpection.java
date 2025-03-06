package com.devsuperior.dsecommerce.services.expections;

public class DatabaseExpection extends RuntimeException {
	public DatabaseExpection(String mgs) {
		super(mgs);
	}
}
