package com.dimed.prova.business;

import java.util.Date;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.dimed.prova.domain.StatusPedido;
import com.dimed.prova.model.ItemPedido;
import com.dimed.prova.model.Pedido;
import com.dimed.prova.repository.PedidoComerceRepository;

@ManagedBean
public class PedidoBusiness {

	@Autowired
	private PedidoComerceRepository pedidoRepository;

	public Boolean existePedido(Long id) {
		return pedidoRepository.exists(id);
	}
	
	public void populaPedido(Pedido pedido){
		pedido.setDataPedido(new Date());
		pedido.setStatusPedido(StatusPedido.ABERTO);
		pedido.setValorTotalPedido(Long.valueOf("0"));
		pedido.setFormaPagamentoPedido("CARTAO");
	}
	
	
	public Pedido fechamento(Long id) {
		Pedido pedido = this.pedidoRepository.findOne(id);
		
		if (pedido.getItemPedido() == null || pedido.getItemPedido().isEmpty()) {
			return new Pedido();
		}
		pedido.setStatusPedido(StatusPedido.FECHADO);
		
		pedido.setValorTotalPedido(CalculaValorTotal(pedido));
		//TODO 
		//gerar cobrança
		//Enviar email
		//
		return this.pedidoRepository.save(pedido);
	}

	private Long CalculaValorTotal(Pedido pedido) {
		Long valorTotal = Long.valueOf("0");
		
		for (ItemPedido itemPedido : pedido.getItemPedido()) {
			Long valorPedido = itemPedido.getQuantidade() * itemPedido.getItem().getValor();
			valorTotal =  valorPedido+ valorTotal;
		}
		
		return valorTotal;
	}

}
