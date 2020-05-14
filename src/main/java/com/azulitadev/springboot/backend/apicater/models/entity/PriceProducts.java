package com.azulitadev.springboot.backend.apicater.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRECIART")
public class PriceProducts implements Serializable {

	@EmbeddedId
    private ProductsPk id;
	
	@Column(name = "MTOPRECIO", columnDefinition="Decimal(10,2) default '0.00'")
	private double price;
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getIdPrice() {
		return id.getIdPrice();
	}

	public void setIdPrice(String idPrice) {
		this.id.setIdPrice(idPrice); 
	}


	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
}
