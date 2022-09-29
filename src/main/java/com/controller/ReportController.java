package com.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.DetailProductService;
import com.service.ExcelService;

@RestController
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	DetailProductService detailProductService;
	@Autowired
	ExcelService excelService;
	
	
	@PostMapping
	@RequestMapping("/ruptura")
	public ResponseEntity getRupturas(@RequestParam String initialDate, @RequestParam String finalDate, @RequestParam Long brand) {
        HttpHeaders headers = new HttpHeaders();
        try {
        	var datas = detailProductService.getRupturaBetweenDateByBrand(brand, LocalDate.parse(initialDate),  LocalDate.parse(finalDate));
    		byte[] excelFile = excelService.generateRupturaExcel(datas);
    		
    		 return ResponseEntity
             		.ok()
             		.headers(headers)
             		.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
             		.body(excelFile);
        }catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	

	@PostMapping
	@RequestMapping("/validade")
	public ResponseEntity getValidade(@RequestParam String initialDate, @RequestParam String finalDate, @RequestParam Long brand) {
        HttpHeaders headers = new HttpHeaders();
        try {
        	var datas = detailProductService.getValidityBetweenDateByBrand(brand, LocalDate.parse(initialDate),  LocalDate.parse(finalDate));
    		byte[] excelFile = excelService.generateValidadeExcel(datas);
    		 return ResponseEntity
             		.ok()
             		.headers(headers)
             		.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
             		.body(excelFile);
        }catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
