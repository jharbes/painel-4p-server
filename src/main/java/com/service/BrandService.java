package com.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controller.dto.BrandDTO;
import com.controller.dto.ShopDTO;
import com.model.Brand;
import com.model.Shop;
import com.repository.BrandRepository;

@Service
public class BrandService {

	@Autowired
	BrandRepository brandRepository;
	@Autowired
	ModelMapper modelMapper;
	
	public String getNameById(Long id) {
		return brandRepository.getNameById(id);
	}
	
	public Brand getBrandById(Long id) {
		return brandRepository.getById(id);
	}
	
	public BrandDTO convertToDto(Brand brand){
		return modelMapper.map(brand, BrandDTO.class);
	}
}
