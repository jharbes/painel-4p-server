package com.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.controller.dto.DataFileOnlyDetailsDTO;
import com.controller.dto.DataFileOnlyPhotoDTO;
import com.form.FilterForm;
import com.repository.DataFileRepository;
import com.repository.DataFileRepositoryImp;
import com.service.BrandService;
import com.service.DataFileService;
import com.service.DetailProductService;
import com.service.PhotoService;
import com.service.PromoterService;
import com.service.ShopService;
import com.util.LocalDateConverter;

@RestController
@RequestMapping("/datafile")
public class DataFileController {

	@Autowired
	DataFileRepository dataFileRepository;
	@Autowired
	DataFileRepositoryImp dataFileRepositoryImp;
	@Autowired
	PromoterService promoterService;
	@Autowired
	BrandService brandService;
	@Autowired
	ShopService shopService;
	@Autowired
	DetailProductService detailProductService;
	@Autowired
	PhotoService photoService;
	@Autowired
	DataFileService dataFileService;

	@ResponseBody
	@PostMapping("/photos")
	public ResponseEntity listPhotos(@RequestParam(name = "initialDate", required = false) String initialDate,
			@RequestParam String finalDate, @RequestParam List<Long> idBrandList, @RequestBody FilterForm filter) {
		try {
			List<DataFileOnlyPhotoDTO> dtos = new ArrayList<>();
			List<Object> datas = new ArrayList<>();
			for (Long idBrand : idBrandList) {
				if (filter != null) {

					datas.add(dataFileService.getPhotos(LocalDateConverter.convertToLocalDate(initialDate),
							LocalDateConverter.convertToLocalDate(finalDate), idBrand, filter.getFilter()));

				} else {
					// realmente necessario caso filter == null?

					datas.add(dataFileService.getPhotos(LocalDateConverter.convertToLocalDate(initialDate),
							LocalDateConverter.convertToLocalDate(finalDate), idBrand, null));
				}
			}

			for (Object obj : datas) {
				Object[] cast = (Object[]) obj;
				DataFileOnlyPhotoDTO dto = new DataFileOnlyPhotoDTO();
				dto.setId(((BigInteger) cast[0]).longValue());
				dto.setBrand(brandService.convertToDto(brandService.getBrandById(((BigInteger) cast[1]).longValue())));
				dto.setShop(shopService.convertToDto(shopService.getBrandById(((BigInteger) cast[2]).longValue())));
				dto.setDate(((java.sql.Date) cast[3]).toLocalDate());
				dto.setPromoter(
						promoterService.convertToDto(promoterService.getBrandById(((BigInteger) cast[5]).longValue())));
				dto.setPhotos(photoService.convertToDTOS(photoService.getPhotosByDataFile(dto.getId())));
				dtos.add(dto);
			}
			return ResponseEntity.status(HttpStatus.OK).body(dtos);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@ResponseBody
	@PostMapping("/details")
	public ResponseEntity listDetails(@RequestParam String initialDate, @RequestParam String finalDate,
			@RequestParam List<Long> idBrandList, @RequestBody FilterForm filter) {
		try {
			List<DataFileOnlyDetailsDTO> dtos = new ArrayList<>();
			List<Object> datas = new ArrayList<>();
			for (Long idBrand : idBrandList) {
				datas.add(dataFileService.getDetails(LocalDateConverter.convertToLocalDate(initialDate),
						LocalDateConverter.convertToLocalDate(finalDate), idBrand, filter.getFilter()));
			}
			for (Object obj : datas) {
				Object[] cast = (Object[]) obj;
				DataFileOnlyDetailsDTO dto = new DataFileOnlyDetailsDTO();
				dto.setId(((BigInteger) cast[0]).longValue());
				dto.setBrand(brandService.convertToDto(brandService.getBrandById(((BigInteger) cast[1]).longValue())));
				dto.setShop(shopService.convertToDto(shopService.getBrandById(((BigInteger) cast[2]).longValue())));
				dto.setDate(((java.sql.Date) cast[3]).toLocalDate());
				dto.setPromoter(
						promoterService.convertToDto(promoterService.getBrandById(((BigInteger) cast[5]).longValue())));
				dto.setDetails(detailProductService
						.convertToDTOS(detailProductService.getDetailProductByDataFile(dto.getId())));
				dtos.add(dto);
			}
			return ResponseEntity.status(HttpStatus.OK).body(dtos);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
