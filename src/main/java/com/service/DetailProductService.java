package com.service;

import java.time.LocalDate;
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
	
	public List<String[]> getRupturaBetweenDateByBrand(Long idBrand,LocalDate initialDate, LocalDate finalDate){
		return detailProductRepository.getRupturaBetweenDateByBrand(idBrand, initialDate, finalDate);
	}
	
	public List<String[]> getValidityBetweenDateByBrand(Long idBrand, LocalDate initialDate, LocalDate finalDate){
		LocalDate validityFinalDate = finalDate.plusMonths(1);
		return detailProductRepository.getValidityBetweenDateByBrand(idBrand, finalDate,initialDate, validityFinalDate);
	}
	public List<DetailProductDTO> convertToDTOS(List<DetailProduct> datas) {
	 return	datas.stream().map(element -> modelMapper.map(element, DetailProductDTO.class)).collect(Collectors.toList());
	}

}
