package com.dimed.prova.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.dimed.prova.domain.StatusPedido;


@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeCliente;

	private Date dataPedido;
	
	private Long valorTotalPedido;
	
	private String formaPagamentoPedido; 
	
	@OneToMany(targetEntity=ItemPedido.class, fetch=FetchType.EAGER)
	@JoinColumn(name="pedido_id")
	private List<ItemPedido> itemPedido;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido statusPedido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Long getValorTotalPedido() {
		return valorTotalPedido;
	}

	public void setValorTotalPedido(Long valorTotalPedido) {
		this.valorTotalPedido = valorTotalPedido;
	}

	public String getFormaPagamentoPedido() {
		return formaPagamentoPedido;
	}

	public void setFormaPagamentoPedido(String formaPagamentoPedido) {
		this.formaPagamentoPedido = formaPagamentoPedido;
	}

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
}
