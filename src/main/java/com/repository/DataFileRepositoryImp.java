package com.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	// Funcao que busca apenas datafile com photos
	public List<Object>  findByBrandwithOnlyPhotos(LocalDate initialDate, LocalDate finalDate, long idBrand,
			Map<String, String[]> filter) {
		
		List<DataFile> datas = new ArrayList<>();
		Map<String, List<Object>> objects = new HashMap<>();
		
		String sql = "SELECT distinct d.id as id_datafile ,d.brand_id as id_brand ,d.shop_id as id_shop ,d.data as date ,d.project as id_project, d.promoter_id as id_promoter " 
				+ " FROM datafile d, shop s, promoter p, detailproduct d2 , datafile_detailproduct dd, product p2 "
			    + " where d.brand_id =:idBrand and d.shop_id = s.id and d.promoter_id = p.id "
				+ " and d.id = dd.datafile_id  and dd.detailproducts_id = d2.id and d2.product_id = p2.id "
				+ " and d.data >= :initialDate and d.data <= :finalDate ";
		
		sql = sql+this.changeSQLString(sql, filter);		
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter("idBrand", idBrand);
		query.setParameter("initialDate", initialDate);
		query.setParameter("finalDate", finalDate);
		changeQueryParameter(query, filter);
		
		return query.getResultList();
	}

	public List<Object> findByBrandwithOnlyDetails(LocalDate initialDate, LocalDate finalDate, long idBrand,
			Map<String, String[]> filter) throws Exception {
		List<DataFile> datas = new ArrayList<>();
		Map<String, List<Object>> objects = new HashMap<>();
		String sql = "SELECT distinct d.id as id_datafile ,d.brand_id as id_brand ,d.shop_id as id_shop ,d.data as date ,d.project as id_project, d.promoter_id as id_promoter " 
		+ " FROM datafile d, shop s, promoter p, detailproduct d2 , datafile_detailproduct dd, product p2 "
	    + " where d.brand_id =:idBrand and d.shop_id = s.id and d.promoter_id = p.id "
		+ " and d.id = dd.datafile_id  and dd.detailproducts_id = d2.id and d2.product_id = p2.id "
		+ " and d.data >= :initialDate and d.data <= :finalDate ";
		
		sql = sql+this.changeSQLString(sql, filter);		
		
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter("idBrand", idBrand);
		query.setParameter("initialDate", initialDate);
		query.setParameter("finalDate", finalDate);
		
		changeQueryParameter(query, filter);
		
		return query.getResultList();
	}
	
	private String changeSQLString(String sql, Map<String, String[]> filter) {
		String return_sql = "";
		if(filter.containsKey("shop")) {
			return_sql = return_sql+ " or s.name in ( :shops ) ";
		}
		if(filter.containsKey("promoter")) {
			return_sql = return_sql+ " or p.name in ( :promoters ) ";
		}
		if(filter.containsKey("product")) {
			return_sql = return_sql+ " or p2.name in ( :products ) ";
		}
		if(filter.containsKey("project")) {
			return_sql = return_sql+ " or d.project in ( :projects ) ";
		}
		if(!return_sql.equals("")) {
			return_sql = " and ( false "+return_sql +")";
		}
		return return_sql;
	}
	
	private void changeQueryParameter(Query query, Map<String, String[]> filter) {
		if(filter.containsKey("shop")) {
			query.setParameter("shops", Arrays.asList(filter.get("shop")));
		}
		if(filter.containsKey("promoter")) {
			query.setParameter("promoters", Arrays.asList(filter.get("promoter")));
		}
		if(filter.containsKey("product")) {
			query.setParameter("products", Arrays.asList(filter.get("product")));
		}
		if(filter.containsKey("project")) {
			query.setParameter("projects", Arrays.asList(filter.get("project")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList()));
		}
	}
}
