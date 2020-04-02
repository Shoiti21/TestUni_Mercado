package com.sistema.service;

import java.util.ArrayList;
import java.util.List;

import com.sistema.email.Email;
import com.sistema.model.Item;
import com.sistema.repository.repPedido;

public class PedidoService {
	private repPedido repPedido;
	private Email email;
	private List<Item> pedidos= new ArrayList<>();
	public PedidoService(repPedido repPedido, Email email) {
		this.repPedido=repPedido;
		this.email=email;
	}
	public void adicionar(Item item) {
		pedidos.add(item);
	}
	public List<Item> getPedidos() {
		return pedidos;
	}
	public double ValorTotal() {
		return pedidos.stream().mapToDouble(i -> i.getValor()*i.getUnidade()).sum();
	}
	public void comprar() {
		repPedido.guardar(pedidos);
		email.enviar(pedidos);
	}

}
