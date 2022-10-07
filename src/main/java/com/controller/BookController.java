package com.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.form.FilterForm;
import com.model.Brand;
import com.service.BrandService;
import com.service.DataFileService;
import com.service.PdfService;

@RestController
public class BookController {
	
	@Autowired
	PdfService pdfService;
	@Autowired
	DataFileService dataFileService;
	@Autowired
	BrandService brandService;
	
	public ResponseEntity generateBookPhotos(@RequestParam(name = "initialDate",required = false) String initialDate,@RequestParam  String finalDate
			,@RequestParam long idBrand, @RequestBody  FilterForm filter) {
		try { 
		   Brand brand = brandService.getBrandById(idBrand);
           var datas = dataFileService.getPhotos(LocalDate.parse(initialDate), LocalDate.parse(finalDate), idBrand, filter.getFilter()).stream().map(element -> ((Object[]) element)).collect(Collectors.toList());
			pdfService.createBookPhotos(datas,brand.getName(),LocalDate.parse(initialDate),LocalDate.parse(finalDate));
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
