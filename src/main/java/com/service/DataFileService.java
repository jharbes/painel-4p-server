package com.service;

import java.time.LocalDate;
import java.util.ArrayList;
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

	public List<Object> getPhotos(LocalDate initialDate, LocalDate finalDate, List<Long> idBrandList,
			Map<String, String[]> filter) throws Exception {
		try {
			List<Object> photosList = new ArrayList<>();

			for (Long idBrand : idBrandList)
				photosList
						.add(dataFileRepositoryimp.findByBrandwithOnlyPhotos(initialDate, finalDate, idBrand, filter));

			return photosList;
		} catch (Exception e) {
			throw new Exception("ERRO NA CONSULTA", e);
		}
	}

	public List<Object> getPhotosToBook(LocalDate initialDate, LocalDate finalDate, List<Long> idBrandList,
			Map<String, String[]> filter) throws Exception {
		try {
			List<Object> photosList = new ArrayList<>();

			for (Long idBrand : idBrandList)
				photosList.add(
						dataFileRepositoryimp.findByBrandwithOnlyPhotosToBook(initialDate, finalDate, idBrand, filter));

			return photosList;
		} catch (Exception e) {
			throw new Exception("ERRO NA CONSULTA", e);
		}
	}

	public List<Object> getDetails(LocalDate initialDate, LocalDate finalDate, List<Long> idBrandList,
			Map<String, String[]> filter) throws Exception {
		try {
			List<Object> detailsList = new ArrayList<>();

			for (Long idBrand : idBrandList)
				detailsList
						.add(dataFileRepositoryimp.findByBrandwithOnlyDetails(initialDate, finalDate, idBrand, filter));

			return detailsList;
		} catch (Exception e) {
			throw new Exception("ERRO NA CONSULTA", e);
		}
	}

	public List<Object> getDetailsToDownload(LocalDate initialDate, LocalDate finalDate, List<Long> idBrandList,
			Map<String, String[]> filter) throws Exception {
		try {
			List<Object> detailsDownloadList = new ArrayList<>();

			for (Long idBrand : idBrandList)
				detailsDownloadList.add(dataFileRepositoryimp.findByBrandwithOnlyDetailsToDownload(initialDate,
						finalDate, idBrand, filter));

			return detailsDownloadList;
		} catch (Exception e) {
			throw new Exception("ERRO NA CONSULTA", e);
		}
	}
}
