package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controller.dto.detail.RupturaByBrandDTO;
import com.controller.dto.detail.ValidityByBrandDTO;
import com.service.DetailProductService;
import com.util.LocalDateConverter;

@RestController
@RequestMapping("/detail")
public class DetailProductController {

	@Autowired
	DetailProductService detailProductService;

	@GetMapping
	@RequestMapping("/ruptura")
	public ResponseEntity getRupturaBetweenDateByBrand(@RequestParam("idBrand") List<String> idBrandList,
			@RequestParam String initialDate, @RequestParam String finalDate) {
		try {
			List<RupturaByBrandDTO> dtos = new ArrayList<>();
			List<String[]> datas = new ArrayList<>();
			for (String idBrand : idBrandList)
				datas.addAll(detailProductService.getRupturaBetweenDateByBrand(Long.parseLong(idBrand),
						LocalDateConverter.convertToLocalDate(initialDate),
						LocalDateConverter.convertToLocalDate(finalDate)));
			for (String[] data : datas) {
				RupturaByBrandDTO rupturaByBrandDTO = new RupturaByBrandDTO();
				rupturaByBrandDTO.setNameShop(data[0]);
				rupturaByBrandDTO.setNameProduct(data[1]);
				rupturaByBrandDTO.setDate(data[2]);
				dtos.add(rupturaByBrandDTO);
			}
			return ResponseEntity.status(HttpStatus.OK).body(dtos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@GetMapping
	@RequestMapping("/validity")
	public ResponseEntity getValidityBetweenDateByBrand(@RequestParam("idBrand") List<String> idBrandList,
			@RequestParam String initialDate, @RequestParam String finalDate) {
		try {
			List<ValidityByBrandDTO> dtos = new ArrayList<>();
			List<String[]> datas = new ArrayList<>();
			for (String idBrand : idBrandList)
				datas.addAll(detailProductService.getValidityBetweenDateByBrand(Long.parseLong(idBrand),
						LocalDateConverter.convertToLocalDate(initialDate),
						LocalDateConverter.convertToLocalDate(finalDate)));
			for (String[] data : datas) {
				ValidityByBrandDTO dto = new ValidityByBrandDTO();
				dto.setDate(data[0]);
				dto.setNameProduct(data[1]);
				dto.setNameShop(data[2]);
				dto.setValidity(data[3]);
				dto.setStock(data[4]);
				dtos.add(dto);
			}
			return ResponseEntity.status(HttpStatus.OK).body(dtos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
