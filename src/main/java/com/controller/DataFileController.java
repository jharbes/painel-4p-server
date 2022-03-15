package com.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.controller.dto.DataFileDTO;
import com.controller.dto.DataFileOnlyDetailsDTO;
import com.controller.dto.DataFileOnlyPhotoDTO;
import com.controller.dto.FilterDTO;
import com.controller.dto.FilterPhotoDTO;
import com.model.DataFile;
import com.repository.DataFileRepository;
import com.repository.DataFileRepositoryImp;
import com.service.DataFileService;
import com.turkraft.springfilter.boot.Filter;

@RestController
@RequestMapping("/datafile")
public class DataFileController {

	@Autowired
	DataFileRepository dataFileRepository;
	@Autowired
	DataFileRepositoryImp dataFileRepositoryImp;
	@Autowired
	DataFileService dataFileService;

	@ResponseBody
	@GetMapping("/photos/{idBrand}")
	public ResponseEntity<List<DataFileOnlyPhotoDTO>> listPhotos(@PathVariable(value = "idBrand") long idBrand) {
		try {
			return ResponseEntity.ok(dataFileService.getPhotos(idBrand));
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@ResponseBody
	@GetMapping("/photos/filter/{idBrand}")
	public ResponseEntity<FilterPhotoDTO>filterPhotos(@PathVariable(value = "idBrand") long idBrand) {
		try {
			return ResponseEntity.ok(dataFileService.getFilterPhoto(idBrand));
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@ResponseBody
	@GetMapping("/details/{idBrand}")
	public ResponseEntity<List<DataFileOnlyDetailsDTO>> listDetails(@PathVariable(value = "idBrand") long idBrand) {
		try {
			return ResponseEntity.ok(dataFileService.getDetails(idBrand));
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/filter")
	public List<DataFile> getFilters() {
		return dataFileRepositoryImp.getFilter();
	}
}
