package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.controller.dto.DataFileOnlyPhotoDTO;
import com.model.DataFile;

public interface DataFileRepository extends JpaSpecificationExecutor<DataFile>, JpaRepository<DataFile, Long> {
}
