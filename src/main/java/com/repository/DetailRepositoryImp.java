package com.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.model.DetailProduct;
import com.model.Photo;

@Service
public class DetailRepositoryImp {
	
	@PersistenceContext
	EntityManager entityManager;
	
	//Recebo como parametro o idDatafile para buscar todos as photos relacionado
	public List<DetailProduct> listDetailsByDataFile(long idDataFile){
		List<Photo> datas = new ArrayList<>();
		Query query = entityManager.createNativeQuery(
				"SELECT * FROM detailproduct dp "
				+ "where dp.id in"
				+ " (select dd.detailproducts_id from datafile_detailproduct dd where dd.datafile_id=:idDataFile)",DetailProduct.class);
		query.setParameter("idDataFile", idDataFile);
		System.out.println(query.getResultList());
		return (List<DetailProduct>) query.getResultList();
	}

}
