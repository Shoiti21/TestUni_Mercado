package com.sistema.model;

public class Item {
	private String Nome;
	private double Valor;
	private int Unidade;
	public Item(String nome, double valor, int unidade) {
		this.Nome=nome;
		this.Valor=valor;
		this.Unidade=unidade;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public double getValor() {
		return Valor;
	}
	public void setValor(double valor) {
		Valor = valor;
	}
	public int getUnidade() {
		return Unidade;
	}
	public void setUnidade(int unidade) {
		Unidade = unidade;
	}
}
