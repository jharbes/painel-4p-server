package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Promoter;

public interface PromoterRepository extends JpaRepository<Promoter, Long> {

    @Query("SELECT p.name FROM Promoter p where p.id = :id")
	String getNameById(@Param(value = "id")Long id);
}
