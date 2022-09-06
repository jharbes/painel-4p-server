package com.controller.dto.filter;

import java.util.List;

public class FilterDetailsDTO {
	private List<Object> shop;
	private List<Object> promoter;
	private List<Object> product;
	private List<Object> status;
	private List<Object> project;
	public List<Object> getShop() {
		return shop;
	}
	public void setShop(List<Object> shop) {
		this.shop = shop;
	}
	public List<Object> getPromoter() {
		return promoter;
	}
	public void setPromoter(List<Object> promoter) {
		this.promoter = promoter;
	}
	public List<Object> getProduct() {
		return product;
	}
	public void setProduct(List<Object> product) {
		this.product = product;
	}
	public List<Object> getStatus() {
		return status;
	}
	public void setStatus(List<Object> status) {
		this.status = status;
	}
	public List<Object> getProject() {
		return project;
	}
	public void setProject(List<Object> project) {
		this.project = project;
	}
	
	
}
