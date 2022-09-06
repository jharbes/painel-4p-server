package com.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.controller.dto.filter.FilterDTO;
import com.controller.dto.filter.FilterDetailsDTO;
import com.controller.dto.filter.FilterGalleryDTO;
import com.repository.FilterRepositoryImp;

@Service
public class FilterService {
	
	@Autowired
	FilterRepositoryImp filterRepositoryImp;
	//Funcao que organiza os valores para usar no filtro dos campos da Datatable do front-end
	//Adiciona a um Map com a chave de cada valor
	public FilterDetailsDTO getAllValuesPossibleToFilterToDataTable( LocalDate initialDate,   LocalDate finalDate,  Long brandId){
		FilterDetailsDTO filterDetailsDTO = new FilterDetailsDTO();
		filterDetailsDTO.setShop(filterRepositoryImp.getAllValuesToShopPossibleToFilter(initialDate, finalDate, brandId));
		filterDetailsDTO.setPromoter(filterRepositoryImp.getAllValuesToPromoterPossibleToFilter(initialDate, finalDate, brandId));
		filterDetailsDTO.setProduct(filterRepositoryImp.getAllValuesToProductPossibleToFilter(initialDate, finalDate, brandId));
		filterDetailsDTO.setStatus(filterRepositoryImp.getAllValuesToStatusPossibleToFilter(initialDate, finalDate, brandId));
		filterDetailsDTO.setProject(filterRepositoryImp.getAllValuesToProjectPossibleToFilter(initialDate, finalDate, brandId));
       
        return filterDetailsDTO;
	}
	
	//Funcao que organiza os valores para usar no filtro dos campos da Galeria de fotos do front-end
		//Adiciona a um Map com a chave de cada valor
		public FilterGalleryDTO getAllValuesPossibleToFilterToGallery( LocalDate initialDate,   LocalDate finalDate,  Long brandId){
			FilterGalleryDTO filterGalleryDTO = new FilterGalleryDTO();
			filterGalleryDTO.setShop(filterRepositoryImp.getAllValuesToShopPossibleToFilter(initialDate, finalDate, brandId));
			filterGalleryDTO.setPromoter(filterRepositoryImp.getAllValuesToPromoterPossibleToFilter(initialDate, finalDate, brandId));
			filterGalleryDTO.setProduct(filterRepositoryImp.getAllValuesToProductPossibleToFilter(initialDate, finalDate, brandId));
			filterGalleryDTO.setSection(filterRepositoryImp.getAllValuesToSectionPossibleToFilter(initialDate, finalDate, brandId));
			filterGalleryDTO.setProject(filterRepositoryImp.getAllValuesToProjectPossibleToFilter(initialDate, finalDate, brandId));
	        return filterGalleryDTO;
		}

}
