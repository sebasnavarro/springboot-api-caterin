package com.azulitadev.springboot.backend.apicater.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICULO")
public class Articulo implements Serializable {

	@Id
	@Column(name = "CDARTICULO")
	private String id;

	@Column(name = "DSARTICUL1")

	private String description;
	
	@Column(name = "Imagen")
	
	private String url;
	
	
	@OneToMany(mappedBy="id.articulo",fetch=FetchType.LAZY,  cascade = CascadeType.ALL)
    private List<PrecioArticulo> precioArticulo;
	
	public Articulo() {
     precioArticulo = new ArrayList<>();
	}

	public List<PrecioArticulo> getPrecioArticulo() {
		return precioArticulo;
	}

	public void setPrecioArticulo(List<PrecioArticulo> precioArticulo) {
		this.precioArticulo = precioArticulo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
