package com.controller.dto.security;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.controller.dto.BrandDTO;
import com.model.User;

public class UserDTO {

	private Long id;
	private String username;
	private String password;
	private BrandDTO brand;

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BrandDTO getBrand() {
		return brand;
	}

	public void setBrand(BrandDTO brand) {
		this.brand = brand;
	}

	public UserDTO convertToDTO(User user,ModelMapper modelMapper) {
		return modelMapper.map(user, UserDTO.class);
	}
}
