package com.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controller.dto.BrandDTO;
import com.controller.dto.ShopDTO;
import com.model.Brand;
import com.model.Shop;
import com.repository.ShopRepository;

@Service
public class ShopService {
	@Autowired
	ShopRepository shopRepository;
	@Autowired
	ModelMapper modelMapper;

	public String getNameById(Long id) {
		return shopRepository.getNameById(id);
	}

	public Shop getBrandById(Long id) {
		return shopRepository.getById(id);
	}

	public ShopDTO convertToDto(Shop shop) {
		return modelMapper.map(shop, ShopDTO.class);
	}
}
