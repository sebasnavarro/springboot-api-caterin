package com.azulitadev.springboot.backend.apicater.models.dao;
import org.springframework.data.repository.CrudRepository;
import com.azulitadev.springboot.backend.apicater.models.entity.Products;
public interface IProductsDao extends CrudRepository<Products, String>{
	
}
