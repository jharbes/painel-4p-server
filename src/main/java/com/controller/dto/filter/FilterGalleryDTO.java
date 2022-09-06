package com.controller.dto.filter;

import java.util.List;

public class FilterGalleryDTO {
	private List<Object> shop;
	private List<Object> promoter;
	private List<Object> product;
	private List<Object> section;
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

	public List<Object> getSection() {
		return section;
	}

	public void setSection(List<Object> section) {
		this.section = section;
	}

	public List<Object> getProject() {
		return project;
	}

	public void setProject(List<Object> project) {
		this.project = project;
	}

}
