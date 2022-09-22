package com.controller.dto.detail;

public class RupturaByBrandDTO {
	private String nameShop;
	private String nameProduct;
	private String date;
	
	public RupturaByBrandDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public RupturaByBrandDTO(String nameShop, String nameProduct, String date) {
		super();
		this.nameShop = nameShop;
		this.nameProduct = nameProduct;
		this.date = date;
	}
	public String getNameShop() {
		return nameShop;
	}
	public void setNameShop(String nameShop) {
		this.nameShop = nameShop;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String namePromoter) {
		this.nameProduct = namePromoter;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
