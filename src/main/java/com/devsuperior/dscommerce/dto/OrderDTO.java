package com.devsuperior.dscommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.OrderStatus;

public class OrderDTO {

	private Long id;
	private Instant moment;
	private OrderStatus status;
	private ClientDTO client;
	private PaymentDTO payment;

	List<OrderItemDTO> items = new ArrayList<>();

	public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentDTO payment) {

		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
		this.payment = payment;
	}

	public OrderDTO(Order o) {
		id = o.getId();
		moment = o.getMoment();
		status = o.getStatus();
		client = new ClientDTO(o.getClient());
		payment = (o.getPayment() == null) ? null : new PaymentDTO(o.getPayment());
		for(OrderItem item: o.getItems()) {
			 OrderItemDTO itemdto = new OrderItemDTO(item);
			 items.add(itemdto);
		}
	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public ClientDTO getClient() {
		return client;
	}

	public PaymentDTO getPayment() {
		return payment;
	}

	public List<OrderItemDTO> getItems() {
		return items;
	}

	public Double getTotal() {
		Double sum = 0.0;
		for (OrderItemDTO item : items) {
			sum = sum + item.getSubtotal();
		}
		return sum;
	}

}
