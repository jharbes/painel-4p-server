package com.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public List<Object> getPhotos(LocalDate initialDate, LocalDate finalDate, Long idBrand,
			Map<String, String[]> filter) throws Exception {
		try {
			return dataFileRepositoryimp.findByBrandwithOnlyPhotos(initialDate, finalDate, idBrand, filter);
		} catch (Exception e) {
			throw new Exception("ERRO NA CONSULTA", e);
		}
	}

	public List<Object> getPhotosToBook(LocalDate initialDate, LocalDate finalDate, Long idBrand,
			Map<String, String[]> filter) throws Exception {
		try {
			return dataFileRepositoryimp.findByBrandwithOnlyPhotosToBook(initialDate, finalDate, idBrand, filter);
		} catch (Exception e) {
			throw new Exception("ERRO NA CONSULTA", e);
		}
	}

	public List<Object> getDetails(LocalDate initialDate, LocalDate finalDate, Long idBrand,
			Map<String, String[]> filter) throws Exception {
		try {
			return dataFileRepositoryimp.findByBrandwithOnlyDetails(initialDate, finalDate, idBrand, filter);
		} catch (Exception e) {
			throw new Exception("ERRO NA CONSULTA", e);
		}
	}

	public List<Object> getDetailsToDownload(LocalDate initialDate, LocalDate finalDate, Long idBrand,
			Map<String, String[]> filter) throws Exception {
		try {
			return dataFileRepositoryimp.findByBrandwithOnlyDetailsToDownload(initialDate, finalDate, idBrand, filter);
		} catch (Exception e) {
			throw new Exception("ERRO NA CONSULTA", e);
		}
	}
}
