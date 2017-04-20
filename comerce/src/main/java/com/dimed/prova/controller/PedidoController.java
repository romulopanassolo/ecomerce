package com.dimed.prova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dimed.prova.business.PedidoBusiness;
import com.dimed.prova.model.Pedido;
import com.dimed.prova.repository.PedidoComerceRepository;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {

    @Autowired
	private PedidoComerceRepository pedidoRepository;
    
    @Autowired
	private PedidoBusiness pedidoBusiness;
    
    
    @RequestMapping(value = "/criarPedido", method = RequestMethod.POST)
	public Pedido criarPedido(@RequestBody Pedido pedido) {	
    	pedidoBusiness.populaPedido(pedido);
		return this.pedidoRepository.save(pedido);
	}
    
	@RequestMapping(value = "/fechamento/{id}", method = RequestMethod.PUT)
	public Pedido fechamento(@PathVariable("id") Long id) {	
		return pedidoBusiness.fechamento(id);
	}
}
