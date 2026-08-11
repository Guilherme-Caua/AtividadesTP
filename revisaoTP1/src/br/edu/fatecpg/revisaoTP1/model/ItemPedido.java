package br.edu.fatecpg.revisaoTP1.model;

public class ItemPedido {
	private String nomePrato;
	private int quantidade;
	private double precoUnitario;
	
	public ItemPedido(String nomePrato, int quantidade, double precoUnitario) {
		this.nomePrato = nomePrato;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
	}

	public String getNomePrato() {
		return nomePrato;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}
}
