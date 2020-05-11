package com.azulitadev.springboot.backend.apicater.models.entity;
import java.util.List;
import java.util.Map;

public class ProductsDto {

	private int count;
	private List<Map<String, Object>> products;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Map<String, Object>> getProducts() {
		return products;
	}

	public void setProducts(List<Map<String, Object>> products) {
		this.products = products;
	}

	
}
