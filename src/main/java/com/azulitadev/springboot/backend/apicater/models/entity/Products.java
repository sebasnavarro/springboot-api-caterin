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
import javax.persistence.Transient;

@Entity
@Table(name = "ARTICULO")
public class Products implements Serializable {

	@Column(name = "CDALMACEND")
	private String category;

	@Column(name = "DSARTICUL1")
	private String name;

	@OneToMany(mappedBy = "id.products", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PriceProducts> prices;

	@Column(name = "STOCK")
	private int quantity;
	
	@Column(name = "Imagen")
	private String image;
	
	@Id
	@Column(name = "CDARTICULO")
	private String id;
	
	@Transient
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PriceProducts> getPrices() {
		return prices;
	}

	public void setPrices(List<PriceProducts> prices) {
		this.prices = prices;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Products() {
		prices = new ArrayList<>();
	}

	
	
	public Products(String category, String name, int quantity, String image, String id, double price) {
		this.category = category;
		this.name = name;
		this.quantity = quantity;
		this.image = image;
		this.id = id;
		this.price = price;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
