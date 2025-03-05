package com.devsuperior.dsecommerce.services.expections;


public class ResourceNotFoundExpection extends RuntimeException{
	
	public ResourceNotFoundExpection(String mensagem) {
		super(mensagem);
	}
}
