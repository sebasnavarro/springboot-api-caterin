package com.azulitadev.springboot.backend.apicater.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRECIART")
public class PriceProducts implements Serializable {
   
	@Embeddable
	static class Pk implements Serializable {

		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name = "CDARTICULO")
		private Products products;
		
		@Column(name = "CDPRECIO", nullable = false, updatable = false)
		private String idPrice;
		
	    public Products getProducts() {
			return products;
		}

		public void setProducts(Products products) {
			this.products = products;
		}

		private static final long serialVersionUID = 1L;
	}

	@EmbeddedId
    private Pk id;
	
	@Column(name = "MTOPRECIO", columnDefinition="Decimal(10,2) default '0.00'")
	private double price;
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
    
	public String getIdPrice() {
		return id.idPrice;
	}

	public void setIdPrice(String idPrice) {
		this.id.idPrice = idPrice;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
