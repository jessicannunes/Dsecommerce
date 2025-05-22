package com.devsuperior.dscommerce.dto;

import java.time.Instant;

import com.devsuperior.dscommerce.entities.Payment;

public class PaymentDTO {
	private Long id;
	private Instant moment;
	
	public PaymentDTO(Long id, Instant moment) {
		
		this.id = id;
		this.moment = moment;
	}
	
	public PaymentDTO(Payment pay) {
		id = pay.getId();
		moment = pay.getMoment();
	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}
	
	
}
