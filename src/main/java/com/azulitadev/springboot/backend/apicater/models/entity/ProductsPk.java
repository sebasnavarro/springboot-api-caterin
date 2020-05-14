package com.azulitadev.springboot.backend.apicater.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ProductsPk implements Serializable{

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
	
   	public String getIdPrice() {
		return idPrice;
	}

	public void setIdPrice(String idPrice) {
		this.idPrice = idPrice;
	}

	public ProductsPk() {
	}




	private static final long serialVersionUID = 1L;

}
