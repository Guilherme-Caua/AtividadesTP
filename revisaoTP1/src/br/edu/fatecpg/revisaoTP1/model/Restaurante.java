package br.edu.fatecpg.revisaoTP1.model;
import java.util.ArrayList;

public class Restaurante {
	private ArrayList<Pedido> pedidos = new ArrayList<>();

	public void adicionarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}

	public void removerPedido(Pedido pedido) {
		pedidos.remove(pedido);
	}

	public Pedido buscarPedido(int numero) {
		for (Pedido pedido : pedidos) {
			if (pedido.getNumero() == numero) {
				return pedido;
			}
		}
		return null;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void exibirPedidos() {
		if (pedidos.isEmpty()) {
			System.out.println("Nenhum pedido realizado.");
			return;
		}
		for (Pedido pedido : pedidos) {
			System.out.println(pedido);
			System.out.println("----------------------------");
		}
	}
}
