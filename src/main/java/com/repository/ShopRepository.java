package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long>{
    @Query("SELECT s.name FROM Shop s where s.id = :id")
	String getNameById(@Param(value = "id")Long id);
}
