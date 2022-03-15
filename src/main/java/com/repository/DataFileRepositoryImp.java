package com.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.form.FilterForm;
import com.model.Brand;
import com.model.DataFile;
import com.model.Photo;
import com.model.Project;
import com.model.Promoter;
import com.model.Shop;

@Repository
public class DataFileRepositoryImp {

	@PersistenceContext
	EntityManager entityManager;
	@Autowired
	PhotoRepositoryImp photoRepositoryImp;
	@Autowired
	DetailRepositoryImp detailRepositoryImp;

	//Funcao que busca apenas datafile com photos
	public List<DataFile> findByBrandwithOnlyPhotos(long idBrand) {
		List<DataFile> datas = new ArrayList<>();
		try {
			TypedQuery<Object[]> query = entityManager
					.createQuery("SELECT distinct d.id,d.shop,b,d.data,d.promoter,d.project"
							+ " FROM DataFile d inner join d.brand b"
							+ " WHERE b.id=:idBrand", Object[].class);
			query.setParameter("idBrand", idBrand);
			for (Object[] row : query.getResultList()) {
				DataFile dataFile = new DataFile();
				dataFile.setId((long) row[0]);
				dataFile.setShop((Shop) row[1]);
				dataFile.setBrand((Brand) row[2]);
				dataFile.setData((LocalDate) row[3]);
				dataFile.setPromoter((Promoter) row[4]);
				dataFile.setProject((Project) row[5]);
				dataFile.setPhotos(photoRepositoryImp.listPhotosByDataFile((long) row[0]));
				datas.add(dataFile);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return datas;
	}
	
	public List<DataFile> findByBrandwithOnlyDetails(long idBrand) {
		List<DataFile> datas = new ArrayList<>();
		try {
			TypedQuery<Object[]> query = entityManager
					.createQuery("SELECT distinct d.id,d.shop,b,d.data,d.promoter,d.project"
							+ " FROM DataFile d inner join d.brand b"
							+ " WHERE b.id=:idBrand", Object[].class);
			query.setParameter("idBrand", idBrand);
			for (Object[] row : query.getResultList()) {
				DataFile dataFile = new DataFile();
				dataFile.setId((long) row[0]);
				dataFile.setShop((Shop) row[1]);
				dataFile.setBrand((Brand) row[2]);
				dataFile.setData((LocalDate) row[3]);
				dataFile.setPromoter((Promoter) row[4]);
				dataFile.setProject((Project) row[5]);
				dataFile.setDetailProducts(detailRepositoryImp.listDetailsByDataFile((long) row[0]));
				datas.add(dataFile);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return datas;
	}
	
	public List<DataFile> getFilter(){
		Query query = entityManager
				.createQuery("SELECT d.shop.name,d.promoter.name,d.project,p.section"
						+ " FROM DataFile d join d.photos p");
		return query.getResultList();
	}
}
