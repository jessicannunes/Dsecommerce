package com.devsuperior.dsecommerce.dto;

import com.devsuperior.dsecommerce.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {
	
	private Long id;
	
	@Size(min=3, max=80, message="Nome precisa ter de 3 a 80 caracteries")
	@NotBlank(message="Campo requerido")
	private String name;
	
	@Size(min=10)
	@NotBlank(message="Descrição no mínimo 10 caracteries")
	private String description;
	
	@Positive(message="O preço deve ser positivo")
	private Double price;
	private String imgUrl;
	

	public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	public ProductDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
		
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}
	
	

}
