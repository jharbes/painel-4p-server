package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
	
	@Query(value = "select p.id from photo p ,datafile d2, datafile_photos dp "
			+ "where d2.id = dp.datafile_id  and dp.photos_id = p.id and d2.id= :idDatafile ",nativeQuery = true)
	List<Long> getPhotosByDataFile(@Param(value = "idDatafile") Long idDataFile);

}
