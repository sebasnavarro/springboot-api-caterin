package com.azulitadev.springboot.backend.apicater.models.service;
import java.util.List;

import com.azulitadev.springboot.backend.apicater.models.entity.Products;
public interface IProductsService{
	
	public List<Products> findAll();
	
	public Products findById(String id);
	
	public Products save(Products products);
	
	public void delete(String id);
	
	

}
