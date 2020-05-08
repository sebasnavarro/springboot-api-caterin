package com.azulitadev.springboot.backend.apicater.models.service;
import java.util.List;
import com.azulitadev.springboot.backend.apicater.models.entity.Articulo;

public interface IArticuloService{
	
	public List<Articulo> findAll();
	
	public Articulo findById(String id);
	
	public Articulo save(Articulo articulo);
	
	public void delete(String id);
	
	public Articulo fecthByIdWithPrice(String id);

}
