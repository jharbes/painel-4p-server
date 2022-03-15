package com.controller.dto;

import com.model.Photo;

public class PhotoDTO {
	private Long id;
	private String section;
	private String url;
	
	public PhotoDTO(Photo photo) {
		this.id = photo.getId();
		this.section = photo.getSection();
		this.url = photo.getUrl();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
