package com.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.model.Photo;
import com.model.Project;

@Repository
public class FilterRepositoryImp {

	@PersistenceContext
	EntityManager entityManager;


	public List<Object> getAllValuesToShopPossibleToFilter(LocalDate initialDate, LocalDate finalDate, Long brandId) {
    	Query query = entityManager
    			.createNativeQuery("select distinct s.\"name\"  from datafile d,shop s  where d.shop_id = s.id and d.brand_id = :brandId and d.\"data\" >= :initialDate and  d.\"data\" <= :finalDate ;");
        query.setParameter("brandId", brandId);
    	query.setParameter("initialDate", initialDate);
    	query.setParameter("finalDate", finalDate);
    	return query.getResultList();
	}
	
	public List<Object> getAllValuesToPromoterPossibleToFilter(LocalDate initialDate, LocalDate finalDate, Long brandId) {
    	Query query = entityManager
    			.createNativeQuery("select distinct p.name  from datafile d,promoter p  where d.promoter_id = p.id and d.brand_id = :brandId and d.\"data\" >= :initialDate and  d.\"data\" <= :finalDate ;");
        query.setParameter("brandId", brandId);
    	query.setParameter("initialDate", initialDate);
    	query.setParameter("finalDate", finalDate);
    	return query.getResultList();
	}
	
	public List<Object> getAllValuesToProductPossibleToFilter(LocalDate initialDate, LocalDate finalDate, Long brandId) {
    	Query query = entityManager
    			.createNativeQuery("select distinct  p.\"name\" "
    					+ "from datafile d,product p, datafile_detailproduct dd, detailproduct d2 "
    					+ "where d.id = dd.datafile_id and dd.detailproducts_id= d2.id and d2.product_id = p.id  and d.brand_id = :brandId and d.\"data\" >= :initialDate and  d.\"data\" <= :finalDate ;");
        query.setParameter("brandId", brandId);
    	query.setParameter("initialDate", initialDate);
    	query.setParameter("finalDate", finalDate);
    	return query.getResultList();
	}
	
	public List<Object> getAllValuesToStatusPossibleToFilter(LocalDate initialDate, LocalDate finalDate, Long brandId) {
    	Query query = entityManager
    			.createNativeQuery("select distinct  d2.ruptura  \r\n"
    					+ "from datafile d, datafile_detailproduct dd, detailproduct d2  \r\n"
    					+ "where d.id = dd.datafile_id and dd.detailproducts_id= d2.id and d.brand_id = :brandId and d.\"data\" >= :initialDate and  d.\"data\" <= :finalDate ;");
        query.setParameter("brandId", brandId);
    	query.setParameter("initialDate", initialDate);
    	query.setParameter("finalDate", finalDate);
    	return query.getResultList();
	}
	
	public List<Object> getAllValuesToProjectPossibleToFilter(LocalDate initialDate, LocalDate finalDate, Long brandId) {
    	Query query = entityManager
    			.createNativeQuery("select distinct  d.project  \r\n"
    					+ "from datafile d\r\n"
    					+ "where d.brand_id = :brandId and d.project is not null  and d.\"data\" >= :initialDate and  d.\"data\" <= :finalDate ;");
        query.setParameter("brandId", brandId);
    	query.setParameter("initialDate", initialDate);
    	query.setParameter("finalDate", finalDate);
    	return query.getResultList();
	}
	
	public List<Object> getAllValuesToSectionPossibleToFilter(LocalDate initialDate, LocalDate finalDate, Long brandId) {
    	Query query = entityManager
    			.createNativeQuery("select distinct  p.section "
    					+ "from datafile d,photo p, datafile_photos dp "
    					+ "where d.id = dp.datafile_id and dp.photos_id= p.id and d.brand_id = :brandId and d.\"data\" >= :initialDate and  d.\"data\" <= :finalDate ;");
        query.setParameter("brandId", brandId);
    	query.setParameter("initialDate", initialDate);
    	query.setParameter("finalDate", finalDate);
    	return query.getResultList();
	}


}
