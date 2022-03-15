package com.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.model.DataFile;
import com.model.Photo;

@Repository
public class PhotoRepositoryImp {

	@PersistenceContext
	EntityManager entityManager;
	
	//Recebo como parametro o idDatafile para buscar todos as photos relacionado
	public List<Photo> listPhotosByDataFile(long idDataFile){
		List<Photo> datas = new ArrayList<>();
		Query query = entityManager.createNativeQuery(
				"SELECT * FROM photo p "
				+ "where p.id in"
				+ " (select df.photos_id from datafile_photos df where df.datafile_id=:idDataFile)",Photo.class);
		query.setParameter("idDataFile", idDataFile);
		System.out.println(query.getResultList());
		return (List<Photo>) query.getResultList();
	}
}
