package com.repository;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.controller.dto.FilterPhotoDTO;
import com.model.Photo;
import com.model.Project;

@Repository
public class FilterRepositoryImp {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public FilterPhotoDTO getFilterPhotos(long idBrand) {
		FilterPhotoDTO dto = new FilterPhotoDTO();
        Set<String> keys = dto.getFilters().keySet();
        for(String key:keys) {
        	Query query;
        	switch (key) {
			case "brand": {
				query = entityManager.createQuery("select distinct b.name from Brand b where b.id=:idBrand");
				query.setParameter("idBrand", idBrand);
				query.getResultList();
				dto.getFilters().get(key).addAll(query.getResultList());
				break;
			}
			case "shop":{
				query = entityManager.createQuery("select distinct d.shop.name from DataFile d "
						+ "inner join d.brand b inner join d.shop s "
						+ "where b.id=:idBrand ");
				query.setParameter("idBrand", idBrand);
				query.getResultList();
				dto.getFilters().get(key).addAll(query.getResultList());
				break;
			}
			case "promoter":{
				query = entityManager.createQuery("select distinct d.promoter.name from DataFile d "
						+ "inner join d.brand b inner join d.promoter p "
						+ "where b.id=:idBrand ");
				query.setParameter("idBrand", idBrand);
				query.getResultList();
				dto.getFilters().get(key).addAll(query.getResultList());
				break;
			}
			case "section": {
				query = entityManager.createNativeQuery(
						"SELECT distinct p.section FROM photo p "
								+ "where p.id in"
								+ " (select df.photos_id from datafile_photos df where df.datafile_id in "
								+ "(select d.id from DataFile d where d.brand_id=:idBrand))");
				query.setParameter("idBrand", idBrand);
				query.getResultList();
				dto.getFilters().get(key).addAll(query.getResultList());
				break;
			}
			case "chain":{
				break;
			}
			case "project":{
				query = entityManager.createQuery("select distinct d.project from DataFile d "
						+ "inner join d.brand b inner join d.promoter p "
						+ "where b.id=:idBrand ",Project.class);
				query.setParameter("idBrand", idBrand);
				dto.getFilters().get(key).addAll(query.getResultList());
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
			}
        }
		return dto;
	}

}
