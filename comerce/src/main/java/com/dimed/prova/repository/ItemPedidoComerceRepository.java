package com.dimed.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dimed.prova.model.ItemPedido;

@Repository
public interface ItemPedidoComerceRepository extends JpaRepository<ItemPedido, Long>{

}
