package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.DetailProduct;

@Repository
public interface DetailProductRepository extends JpaRepository<DetailProduct, Long>{
  
	@Query(value = "select d.id from detailproduct d ,datafile d2, datafile_detailproduct dd "
			+ "where d2.id = dd.datafile_id  and dd.detailproducts_id = d.id and d2.id= :idDatafile ",nativeQuery = true)
	List<Long> getDetailProductByDataFile(@Param(value = "idDatafile") Long idDataFile);
}
