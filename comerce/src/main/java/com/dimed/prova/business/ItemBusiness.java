package com.dimed.prova.business;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.dimed.prova.model.Item;
import com.dimed.prova.repository.ItemComerceRepository;

@ManagedBean
public class ItemBusiness {
	
	@Autowired
	private ItemComerceRepository itemRepository;
	
	public Item alteraValor(Long id, Long valor) {
		Item item = itemRepository.findOne(id);
		item.setValor(valor);
		return this.itemRepository.save(item);
	}
	
	public Boolean existeItem(Long id){
		return this.itemRepository.exists(id);
	}
	
}
