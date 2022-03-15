package com.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controller.dto.DataFileOnlyDetailsDTO;
import com.controller.dto.DataFileOnlyPhotoDTO;
import com.controller.dto.DetailProductDTO;
import com.controller.dto.FilterPhotoDTO;
import com.model.DataFile;
import com.repository.DataFileRepository;
import com.repository.DataFileRepositoryImp;
import com.repository.FilterRepositoryImp;
import com.util.ModelMapperConverter;

@Service
public class DataFileService {

	@Autowired
	DataFileRepositoryImp dataFileRepositoryimp;
	@Autowired
	FilterRepositoryImp filterRepositoryImp;
	@Autowired
    ModelMapperConverter modelConverter;
	
	
	public List<DataFileOnlyPhotoDTO> getPhotos(Long idBrand){
		List<DataFile> datas = dataFileRepositoryimp.findByBrandwithOnlyPhotos(idBrand);
		List<DataFileOnlyPhotoDTO> dtos = datas.stream().map(data -> new DataFileOnlyPhotoDTO(data)).collect(Collectors.toList());
	    return dtos;
	}
	
	public FilterPhotoDTO getFilterPhoto(long idBrand){
		FilterPhotoDTO dtos = filterRepositoryImp.getFilterPhotos(idBrand);
		return dtos;
	}
	
	public List<DataFileOnlyDetailsDTO> getDetails(long idBrand) {
		List<DataFile> datas = dataFileRepositoryimp.findByBrandwithOnlyDetails(idBrand);
		List<DataFileOnlyDetailsDTO> dtos = datas.stream().map(data -> new DataFileOnlyDetailsDTO(data)).collect(Collectors.toList());
	    return dtos;
	}
	
	

}
