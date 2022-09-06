package com.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controller.dto.BrandDTO;
import com.controller.dto.PromoterDTO;
import com.model.Brand;
import com.model.Promoter;
import com.repository.PromoterRepository;

@Service
public class PromoterService {
	
	@Autowired
	PromoterRepository promoterRepository;
	@Autowired
	ModelMapper modelMapper;
	
	public String getNameById(Long id) {
		return promoterRepository.getNameById(id);
	}
	
	public Promoter getBrandById(Long id) {
		return promoterRepository.getById(id);
	}
	
	public PromoterDTO convertToDto(Promoter promoter){
		return modelMapper.map(promoter, PromoterDTO.class);
	}

}
