package com.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.model.DataFile;
import com.model.Project;

public class DataFileOnlyPhotoDTO {
	
	private long id;
	private String shop;
	private List<PhotoDTO> photos;
	private String brand;
	private LocalDate date;
	private String promoter;
	private Project project;
	
	public DataFileOnlyPhotoDTO(DataFile dataFile) {
		this.id = dataFile.getId();
		this.brand = dataFile.getBrand().getName();
		this.shop = dataFile.getShop().getName();
		this.date = dataFile.getData();
		this.promoter = dataFile.getPromoter().getName();
		this.project = dataFile.getProject();
		this.photos = dataFile.getPhotos().stream().map(data -> new PhotoDTO(data)).collect(Collectors.toList());
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	public List<PhotoDTO> getPhotos() {
		return photos;
	}
	public void setPhotos(List<PhotoDTO> photos) {
		this.photos = photos;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPromoter() {
		return promoter;
	}
	public void setPromoter(String promoter) {
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
