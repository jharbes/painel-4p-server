package com.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.model.DataFile;
import com.model.Project;

public class DataFileOnlyPhotoDTO {
	
	private long id;
	private ShopDTO shop;
	private List<PhotoDTO> photos;
	private BrandDTO brand;
	private LocalDate date;
	private PromoterDTO promoter;
	private Project project;
	
	public DataFileOnlyPhotoDTO() {
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
	public List<PhotoDTO> getPhotos() {
		return photos;
	}
	public void setPhotos(List<PhotoDTO> photos) {
		this.photos = photos;
	}
	public BrandDTO getBrand() {
		return brand;
	}
	public void setBrand(BrandDTO brand) {
		this.brand = brand;
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
