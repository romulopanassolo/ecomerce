package com.dimed.prova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dimed.prova.model.Item;

@Repository
public interface ItemComerceRepository extends JpaRepository<Item, Long>{

	@Query("SELECT i.nome FROM Item i where i.nome like %:nome%") 
	List<String> findByNome(@Param("nome") String nome);
	
}
