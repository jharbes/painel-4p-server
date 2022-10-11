package com.util.book;

import java.util.List;

public class DataBook {
	private String nameShop;
	private String namePromoter;
	private String date;
	private String nameProject;
	private List<PhotoDataBook> photoDataBooks;
	
	public String getNameShop() {
		return nameShop;
	}
	public void setNameShop(String nameShop) {
		this.nameShop = nameShop;
	}
	public String getNamePromoter() {
		return namePromoter;
	}
	public void setNamePromoter(String namePromoter) {
		this.namePromoter = namePromoter;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNameProject() {
		return nameProject;
	}
	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}
	public List<PhotoDataBook> getPhotoDataBooks() {
		return photoDataBooks;
	}
	public void setPhotoDataBooks(List<PhotoDataBook> photoDataBooks) {
		this.photoDataBooks = photoDataBooks;
	}
}
