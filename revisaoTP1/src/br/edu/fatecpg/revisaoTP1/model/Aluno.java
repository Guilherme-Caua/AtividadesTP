package br.edu.fatecpg.revisaoTP1.model;

public class Aluno {
	private String nome;
	private double notaFinal;
	private int horasUltimos2Meses;

	public Aluno(String nome) {
		this.nome = nome;
		this.notaFinal = 0.0;
		this.horasUltimos2Meses = 0;
	}

	public String getNome() {
		return nome;
	}

	public double getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}

	public int getHorasUltimos2Meses() {
		return horasUltimos2Meses;
	}

	public void adicionarHoras(int horas) {
		this.horasUltimos2Meses += horas;
	}
}
