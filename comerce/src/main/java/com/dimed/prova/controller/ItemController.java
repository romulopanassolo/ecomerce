package com.dimed.prova.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dimed.prova.business.ItemBusiness;
import com.dimed.prova.model.Item;
import com.dimed.prova.repository.ItemComerceRepository;




@RestController
@RequestMapping("api/item")
public class ItemController {

    @Autowired
	private ItemComerceRepository itemRepository;
    
    @Autowired
    private ItemBusiness itemBusiness;
	
	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public Item cadastra(@RequestBody Item item) {		
		return this.itemRepository.save(item);
	}
	
	
	@RequestMapping(value = "/altera/{id}/{valor}", method = RequestMethod.PUT)
	public Item altera(@PathVariable("id") Long id, @PathVariable("valor") Long valor) {
		return itemBusiness.alteraValor(id, valor); 
	}
	
	
	@RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
	public Item search(@PathVariable("id") Long id) {		
		return this.itemRepository.findOne(id);
	}
	
	
	@RequestMapping(value = "/autoComplete/{nome}", method = RequestMethod.GET)
	public ArrayList<String> busca(@PathVariable("nome") String nome) {		
		return (ArrayList<String>) this.itemRepository.findByNome(nome);
	}
	
	
	
}
