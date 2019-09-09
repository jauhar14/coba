package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.DinarModel;


public interface DinarRepository extends JpaRepository<DinarModel, String> {

	@Query("SELECT D FROM DinarModel D WHERE D.id = ?1")
	DinarModel searchIdDinar (Integer id);
	
	@Query("SELECT D FROM DinarModel D WHERE D.nomorNota LIKE %?1%")
	DinarModel searchNomorNota (String nomorNota);	
	
	@Query("SELECT MAX(D.id) FROM DinarModel D")
	Integer searchMaxId();
}
