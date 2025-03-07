package com.devsuperior.dsecommerce.dto;

public class FieldMessage {
	private String fildname;
	private String message;
	
	
	public FieldMessage(String fildname, String message) {
		super();
		this.fildname = fildname;
		this.message = message;
	}


	public String getFildname() {
		return fildname;
	}


	public String getMessage() {
		return message;
	}
	
	
	
	
}
