package com.azulitadev.springboot.backend.apicater.models.dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.azulitadev.springboot.backend.apicater.models.entity.Articulo;

public interface IArticuloDao extends CrudRepository<Articulo, String>{
	
	@Query("SELECT DISTINCT a FROM Articulo a INNER JOIN a.precioArticulo b INNER JOIN b.id c where a.id=?1")
	public Articulo fecthByIdWithPrice(String id);
   

}
