package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controller.dto.DetailProductDTO;
import com.model.DetailProduct;
import com.repository.DetailProductRepository;

@Service
public class DetailProductService {
	
	@Autowired
	private DetailProductRepository detailProductRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	public List<DetailProduct> getDetailProductByDataFile(Long idDataFile){
		List<DetailProduct> detailProducts = new ArrayList<>();
		 for(Long id: detailProductRepository.getDetailProductByDataFile(idDataFile)) {
			 detailProducts.add(detailProductRepository.getById(id));
		 }
		 return detailProducts;
	}
	
	public List<DetailProductDTO> convertToDTOS(List<DetailProduct> datas) {
	 return	datas.stream().map(element -> modelMapper.map(element, DetailProductDTO.class)).collect(Collectors.toList());
	}

}
