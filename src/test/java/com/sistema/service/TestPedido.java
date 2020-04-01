package com.sistema.service;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.sistema.email.Email;
import com.sistema.model.Item;
import com.sistema.repository.repPedido;

public class TestPedido {
	private PedidoService pedidos;
	@Mock
	private repPedido repPedido;
	@Mock
	private Email email;
	@Before
	public void inicializacao() {
		MockitoAnnotations.initMocks(this);
		pedidos=new PedidoService(repPedido,email);
	}
	@Test
	public void deveAdicionarPèdido() throws Exception {
		Item item=new Item("Notebook",2500.0,3);
		pedidos.adicionar(item);
	}
	@Test
	public void deveCalcularValorTotalDePedidoVazio() throws Exception {
		Assert.assertThat(pedidos.ValorTotal(), Matchers.greaterThanOrEqualTo(0.0));
	}
	@Test
	public void deveCalcularValorTotalDeDoisItens() throws Exception {
		Item item=new Item("Notebook",2500.0,3);
		Item item2=new Item("Video-game",1500.0,2);
		pedidos.adicionar(item);
		pedidos.adicionar(item2);
		Assert.assertEquals(10500.0, pedidos.ValorTotal(), 0.01);
		Assert.assertThat(pedidos.ValorTotal(), Matchers.greaterThanOrEqualTo(0.0));
	}
	@Test
	public void deveEmitirNotaFiscalEmail() throws Exception {
		pedidos.comprar();
		Mockito.verify(repPedido).guardar();
		Mockito.verify(email).enviar();
	}

}
