package com.controller.dto;

import java.util.List;

public class FilterDTO {
	private List<String> projects;
	private List<String> shops;
	private List<String> chains;
	private List<String> promoter;
	private List<String> products;
	private List<String> status;

	public List<String> getProjects() {
		return projects;
	}
	public void setProjects(List<String> projects) {
		this.projects = projects;
	}
	public List<String> getShops() {
		return shops;
	}
	public void setShops(List<String> shops) {
		this.shops = shops;
	}
	public List<String> getChains() {
		return chains;
	}
	public void setChains(List<String> chains) {
		this.chains = chains;
	}
	public List<String> getPromoter() {
		return promoter;
	}
	public void setPromoter(List<String> promoter) {
		this.promoter = promoter;
	}
	public List<String> getProducts() {
		return products;
	}
	public void setProducts(List<String> products) {
		this.products = products;
	}
	public List<String> getStatus() {
		return status;
	}
	public void setStatus(List<String> status) {
		this.status = status;
	}
}
