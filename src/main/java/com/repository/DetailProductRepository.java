package com.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.DetailProduct;

import lombok.val;

@Repository
public interface DetailProductRepository extends JpaRepository<DetailProduct, Long>{
  
	@Query(value = "select d.id from detailproduct d ,datafile d2, datafile_detailproduct dd "
			+ "where d2.id = dd.datafile_id  and dd.detailproducts_id = d.id and d2.id= :idDatafile ",nativeQuery = true)
	List<Long> getDetailProductByDataFile(@Param(value = "idDatafile") Long idDataFile);
	
	@Query(value = "SELECT distinct s.\"name\" as shop ,p2.\"name\" as product ,d.data as date, d2.ruptura "
			+ "FROM datafile d, shop s, promoter p, detailproduct d2 , datafile_detailproduct dd, product p2 "
			+ "where d.brand_id = :idBrand and d.shop_id = s.id "
			+ "and d.id = dd.datafile_id  and dd.detailproducts_id = d2.id and d2.product_id = p2.id "
			+ "and d.data >= :initialDate and d.data <= :finalDate and d2.ruptura = 'SIM' ", nativeQuery = true)
	List<String[]> getRupturaBetweenDateByBrand(@Param(value ="idBrand") Long idBrand,@Param(value = "initialDate") LocalDate initialDate, @Param(value = "finalDate") LocalDate finalDate );

	
	@Query(value = "select distinct  d.\"data\", pd.\"name\" as p ,s.\"name\" as s,dp.validity,dp.stock \r\n"
			+ "FROM datafile d, shop s, promoter p, detailproduct dp , datafile_detailproduct dd, product pd\r\n"
			+ "where d.brand_id = :idBrand and d.shop_id = s.id \r\n"
			+ "and d.id = dd.datafile_id  and dd.detailproducts_id = dp.id and dp.product_id = pd.id \r\n"
			+ "and dp.validity >= :finalDate and dp.validity <= :validityFinalDate  and dp.stock > 0 and \r\n"
			+ "d.\"data\" = (SELECT max(d2.data) \r\n"
			+ "FROM datafile d2, shop s2, promoter p2, detailproduct dp2 , datafile_detailproduct dd2, product pd2\r\n"
			+ "where d2.brand_id = :idBrand and d2.shop_id = s2.id \r\n"
			+ "and d2.id = dd2.datafile_id  and dd2.detailproducts_id = dp2.id and dp2.product_id = pd2.id \r\n"
			+ "and dp2.validity >= :finalDate and dp2.validity <= :validityFinalDate  and dp2.stock > 0 \r\n"
			+ "and pd2.id = pd.id and s2.id = s.id \r\n"
			+ "group by pd2.\"name\",s2.name) \r\n"
			+ "and d.\"data\" >= :initialDate", nativeQuery = true)
	List<String[]> getValidityBetweenDateByBrand(@Param(value ="idBrand") Long idBrand, @Param(value = "finalDate") LocalDate finalDate, @Param(value = "initialDate") LocalDate initialDate, @Param(value = "validityFinalDate") LocalDate validityFinalDate);
}
