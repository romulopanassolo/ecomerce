package com.dimed.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dimed.prova.model.Pedido;

@Repository
public interface PedidoComerceRepository extends JpaRepository<Pedido, Long>{
	
}
