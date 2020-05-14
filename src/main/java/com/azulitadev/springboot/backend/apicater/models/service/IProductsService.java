package com.azulitadev.springboot.backend.apicater.models.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.azulitadev.springboot.backend.apicater.models.entity.IProductsProjection;
import com.azulitadev.springboot.backend.apicater.models.entity.Products;
public interface IProductsService{
	
	public List<Products> findAll();
	
	public Products findById(String id);
	
	public Products save(Products products);
	
	public void delete(String id);
	
	public Page<IProductsProjection> find(Pageable pageable);
	
	public List<IProductsProjection>finByTerminal(String terminal);

}
