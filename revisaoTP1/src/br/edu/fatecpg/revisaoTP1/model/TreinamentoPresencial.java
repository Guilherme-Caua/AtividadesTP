package br.edu.fatecpg.revisaoTP1.model;

public class TreinamentoPresencial extends Treinamento {
	private String local;

	public TreinamentoPresencial(int id, String nomeInstrutor, String linguagemEnsinada, String local) {
		super(id, nomeInstrutor, linguagemEnsinada);
		this.local = local;
	}

	public String getLocal() {
		return local;
	}

	public void reservarSala(String sala) {
		this.local = sala;
		System.out.println("Sala reservada para o treinamento presencial #" + id + ": " + sala);
	}

	@Override
	public String toString() {
		return super.toString() + " | Presencial - Local: " + local;
	}
}
