package com.dimed.prova.business;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean
public class ItemPedidoBusiness {

	@Autowired
	private ItemBusiness itemBusiness;

	@Autowired
	private PedidoBusiness pedidoBusiness;

	public Boolean existeItemEPedido(Long idItem, Long idPedido) {
		return itemBusiness.existeItem(idItem) && pedidoBusiness.existePedido(idPedido);
	}

}
