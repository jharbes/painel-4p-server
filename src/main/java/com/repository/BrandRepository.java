package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("SELECT b.name FROM Brand b where b.id = :id")
	String getNameById(@Param(value = "id")Long id);

}
