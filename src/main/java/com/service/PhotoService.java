package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controller.dto.DetailProductDTO;
import com.controller.dto.PhotoDTO;
import com.model.DetailProduct;
import com.model.Photo;
import com.repository.DetailProductRepository;
import com.repository.PhotoRepository;

@Service
public class PhotoService {
	
	
	@Autowired
	private PhotoRepository photoRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	public List<Photo> getPhotosByDataFile(Long idDataFile){
		List<Photo> photos = new ArrayList<>();
		 for(Long id: photoRepository.getPhotosByDataFile(idDataFile)) {
			 photos.add(photoRepository.getById(id));
		 }
		 return photos;
	}
	
	
	
	public List<PhotoDTO> convertToDTOS(List<Photo> datas) {
		 return	datas.stream().map(element -> modelMapper.map(element, PhotoDTO.class)).collect(Collectors.toList());
		}
	

}
