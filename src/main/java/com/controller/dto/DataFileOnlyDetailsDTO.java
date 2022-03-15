package com.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.model.DataFile;
import com.model.Project;

public class DataFileOnlyDetailsDTO {
	
	private long id;
	private String shop;
	private List<DetailProductDTO> details;
	private String brand;
	private LocalDate date;
	private String promoter;
	private Project project;
	
	public DataFileOnlyDetailsDTO(DataFile dataFile) {
	    this.id = dataFile.getId();
	    this.shop = dataFile.getShop().getName();
	    this.brand = dataFile.getBrand().getName();
	    this.date = dataFile.getData();
	    this.promoter = dataFile.getPromoter().getName();
	    this.project = dataFile.getProject();
	    this.details = dataFile.getDetailProducts().stream().map(data -> new DetailProductDTO(data)).collect(Collectors.toList());
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
	public List<DetailProductDTO> getDetails() {
		return details;
	}
	public void setDetails(List<DetailProductDTO> details) {
		this.details = details;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
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
}
