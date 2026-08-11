package br.edu.fatecpg.revisaoTP1.model;
import java.util.ArrayList;

public class Pedido {
	private int numero;
	private double taxaEntrega;
	private String mesaReservada;
	private ArrayList<ItemPedido> itens = new ArrayList<>();

	public Pedido(int numero, double taxaEntrega) {
		this.numero = numero;
		this.taxaEntrega = taxaEntrega;
	}

	public int getNumero() {
		return numero;
	}

	public double getTaxaEntrega() {
		return taxaEntrega;
	}

	public void setTaxaEntrega(double taxaEntrega) {
		this.taxaEntrega = taxaEntrega;
	}

	public ArrayList<ItemPedido> getItens() {
		return itens;
	}

	public void adicionarItem(ItemPedido item) {
		itens.add(item);
	}

	public void removerItem(ItemPedido item) {
		itens.remove(item);
	}

	public String reservarMesa(int numeroMesa) {
		this.mesaReservada = "Mesa " + numeroMesa;
		return this.mesaReservada + " reservada para o pedido " + numero;
	}

	public double calcularTotalPedido() {
		double total = 0;
		for (ItemPedido item : itens) {
			total += item.getPrecoUnitario() * item.getQuantidade();
		}
		return total + taxaEntrega;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Pedido #").append(numero);
		if (mesaReservada != null) {
			sb.append(" - ").append(mesaReservada);
		}
		sb.append("\n");
		for (ItemPedido item : itens) {
			sb.append("  ").append(item.getQuantidade()).append("x ")
			  .append(item.getNomePrato()).append(" - R$ ")
			  .append(String.format("%.2f", item.getPrecoUnitario())).append("\n");
		}
		sb.append("  Taxa de entrega: R$ ").append(String.format("%.2f", taxaEntrega)).append("\n");
		sb.append("  Total: R$ ").append(String.format("%.2f", calcularTotalPedido()));
		return sb.toString();
	}
}
