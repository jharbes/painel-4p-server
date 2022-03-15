package com.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.model.DetailProduct;


public class DetailProductDTO {
	private long id;
	private String product;
	private BigDecimal price;
	private LocalDate validity;
	private String ruptura;
	private long stock;
	
	public DetailProductDTO(DetailProduct detail) {
		this.id = detail.getId();
		this.product = detail.getProduct().getName();
		this.price = detail.getPrice();
		this.validity = detail.getValidity();
		this.ruptura = detail.getRuptura();
		this.stock = detail.getStock();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public LocalDate getValidity() {
		return validity;
	}
	public void setValidity(LocalDate validity) {
		this.validity = validity;
	}
	public String getRuptura() {
		return ruptura;
	}
	public void setRuptura(String ruptura) {
		ruptura = ruptura;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
}
