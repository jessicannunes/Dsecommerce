package com.devsuperior.dsecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsecommerce.dto.ProductDTO;
import com.devsuperior.dsecommerce.entities.Product;
import com.devsuperior.dsecommerce.repositories.ProductRepository;
import com.devsuperior.dsecommerce.services.expections.DatabaseExpection;
import com.devsuperior.dsecommerce.services.expections.ResourceNotFoundExpection;

import jakarta.persistence.EntityNotFoundException;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Product product = repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundExpection("Recurso não encontrado"));
		return new ProductDTO(product);
		
	}
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAll(Pageable pageable){
		Page<Product> result = repository.findAll(pageable);
		return result.map(x -> new ProductDTO(x));
	}
	
	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}
	
	@Transactional
	public ProductDTO upload(Long id, ProductDTO dto) {
		
		try {
			Product entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ProductDTO(entity);
		}
		catch(EntityNotFoundException e){
			throw new ResourceNotFoundExpection("Recurso não encontrato");
		}
		
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundExpection("Recurso não encontrado");
		}
		try {
	        	repository.deleteById(id);    		
		}
	    catch (DataIntegrityViolationException e) {
	        	throw new DatabaseExpection("Falha de integridade referencial");
	   	}
		
	}
	
	private void copyDtoToEntity(ProductDTO dto, Product entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setImgUrl(dto.getImgUrl());
		entity.setPrice(dto.getPrice());
		
	}
	

}
