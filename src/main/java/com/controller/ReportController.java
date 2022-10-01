package com.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.form.FilterForm;
import com.model.DetailProduct;
import com.model.Project;
import com.service.DataFileService;
import com.service.DetailProductService;
import com.service.ExcelService;
import com.util.LocalDateConverter;

@RequestMapping("/report")
@RestController
public class ReportController {
	
	@Autowired
	DataFileService dataFileService;
	@Autowired
	DetailProductService detailProductService;
	@Autowired
	ExcelService excelService;
	@ResponseBody
	@PostMapping("/details")
	public ResponseEntity listDetailsToDownload(@RequestParam String initialDate,@RequestParam  String finalDate
			,@RequestParam long idBrand, @RequestBody(required = false)  FilterForm filter) {
        HttpHeaders headers = new HttpHeaders();
		List<String[]> datas_excel = new ArrayList<>();

        try 
        	List<Object> datas;
        	if(filter == null) {
        		datas = dataFileService.getDetailsToDownload(LocalDateConverter.convertToLocalDate(initialDate) , LocalDateConverter.convertToLocalDate(finalDate)
        				,idBrand,null);
        	}else {
        		datas = dataFileService.getDetailsToDownload(LocalDateConverter.convertToLocalDate(initialDate) , LocalDateConverter.convertToLocalDate(finalDate)
        				,idBrand,filter.getFilter());
        	}

    		for(Object object: datas) {
    			Object[] cast = (Object[]) object;
    			String[] data = new String[8];
    			data[0] = ((java.sql.Date) cast[1]).toLocalDate().toString();
                data[1] = (String) cast[2];
                data[2] = (Project.valueOf(((Integer)cast[3])).isPresent())? Project.valueOf(((Integer)cast[3])).get().toString() : null;
                for(DetailProduct detail: detailProductService.getDetailProductByDataFile(((BigInteger)cast[0]).longValue())){
                	data[3] = detail.getProduct().getName();
                	data[4] = (detail.getPrice()!=null)? detail.getPrice().toString() : null;
                	data[5] = (detail.getStock()!=null)? Long.toString(detail.getStock()) : null;
                    data[6] = (detail.getValidity()!=null)? detail.getValidity().toString(): null;
                    data[7] = detail.getRuptura();
                    datas_excel.add(data);
                }            
    		}
    		return ResponseEntity
            		.ok()
            		.headers(headers)
            		.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
            		.body(excelService.generateDetailsProductExcel(datas_excel));
        }catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
