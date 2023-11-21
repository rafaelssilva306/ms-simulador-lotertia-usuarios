package com.loterias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loterias.model.Aposta;

@Repository
public interface ApostaRepository extends JpaRepository<Aposta, Integer>{
	
	 List<Aposta> findAll();

}
