package com.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.model.DataFile;
import com.model.Project;

public class DataFileOnlyDetailsDTO {
	
	private long id;
	private ShopDTO shop;
	private List<DetailProductDTO> details;
	private BrandDTO brand;
	private LocalDate date;
	private PromoterDTO promoter;
	private Project project;
	
	public DataFileOnlyDetailsDTO() {
		
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ShopDTO getShop() {
		return shop;
	}
	public void setShop(ShopDTO shop) {
		this.shop = shop;
	}
	public List<DetailProductDTO> getDetails() {
		return details;
	}
	public void setDetails(List<DetailProductDTO> details) {
		this.details = details;
	}
	public BrandDTO getBrand() {
		return brand;
	}
	public void setBrand(BrandDTO brand) {
		this.brand = brand;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public PromoterDTO getPromoter() {
		return promoter;
	}
	public void setPromoter(PromoterDTO promoter) {
		this.promoter = promoter;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
}
