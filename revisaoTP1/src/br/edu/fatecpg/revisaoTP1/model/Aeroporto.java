package br.edu.fatecpg.revisaoTP1.model;

import java.util.ArrayList;
import br.edu.fatecpg.revisaoTP1.model.*;

public class Aeroporto {
	private ArrayList<Voo> voos = new ArrayList<>();

	public void adicionarVoo(Voo voo) {
		voos.add(voo);
	}

	public void removerVoo(Voo voo) {
		voos.remove(voo);
	}

	public Voo buscarVoo(String numeroVoo) {
		for (Voo voo : voos) {
			if (voo.getNumeroVoo().equals(numeroVoo)) {
				return voo;
			}
		}
		return null;
	}

	public ArrayList<Voo> getVoos() {
		return voos;
	}

	public void exibirVoos() {
		if (voos.isEmpty()) {
			System.out.println("Nenhum voo cadastrado.");
			return;
		}
		for (Voo voo : voos) {
			voo.imprimirPassagem();
		}
	}
}
