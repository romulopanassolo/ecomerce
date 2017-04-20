package com.dimed.prova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dimed.prova.business.ItemPedidoBusiness;
import com.dimed.prova.model.ItemPedido;
import com.dimed.prova.repository.ItemPedidoComerceRepository;

@RestController
@RequestMapping("api/itemPedido")
public class ItemPedidoController {

	@Autowired
	private ItemPedidoBusiness itemPedidoBusiness;

	@Autowired
	private ItemPedidoComerceRepository itemPedidoRepository;

	@RequestMapping(value = "/cadastra", method = RequestMethod.POST)
	public ItemPedido cadastra(@RequestBody ItemPedido itemPedido) {
		
		if (itemPedidoBusiness.existeItemEPedido(itemPedido.getItem().getId(), itemPedido.getPedido().getId())) {
			return this.itemPedidoRepository.save(itemPedido);
		}
		
		return new ItemPedido();

	}

}
