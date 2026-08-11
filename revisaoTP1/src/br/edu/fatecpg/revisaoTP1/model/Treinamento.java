package br.edu.fatecpg.revisaoTP1.model;

import java.util.ArrayList;

public class Treinamento {
	private static final int LIMITE_HORAS_2_MESES = 80;

	protected int id;
	protected String nomeInstrutor;
	protected String linguagemEnsinada;
	protected ArrayList<Aluno> alunos = new ArrayList<>();
	protected int cargaHoraria;
	protected boolean instrutorDisponivel;

	public Treinamento(int id, String nomeInstrutor, String linguagemEnsinada) {
		this.id = id;
		this.nomeInstrutor = nomeInstrutor;
		this.linguagemEnsinada = linguagemEnsinada;
		this.instrutorDisponivel = true;
	}

	public int getId() {
		return id;
	}

	public String getNomeInstrutor() {
		return nomeInstrutor;
	}

	public String getLinguagemEnsinada() {
		return linguagemEnsinada;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setInstrutorDisponivel(boolean disponivel) {
		this.instrutorDisponivel = disponivel;
	}

	public boolean verificarDisponibilidade() {
		return instrutorDisponivel;
	}

	public void definirCargaHoraria(int horas) {
		this.cargaHoraria = horas;
	}

	public boolean verificarUltimoTreinamento(Aluno aluno) {
		return (aluno.getHorasUltimos2Meses() + cargaHoraria) <= LIMITE_HORAS_2_MESES;
	}

	public void matricularAluno(Aluno aluno) {
		if (!verificarDisponibilidade()) {
			System.out.println("Instrutor indisponível, matrícula não realizada.");
			return;
		}
		if (!verificarUltimoTreinamento(aluno)) {
			System.out.println(aluno.getNome() + " excede o limite de 80h a cada 2 meses, matrícula não realizada.");
			return;
		}
		alunos.add(aluno);
		aluno.adicionarHoras(cargaHoraria);
		System.out.println(aluno.getNome() + " matriculado(a) com sucesso no treinamento " + id + ".");
	}

	public double calcularMediaAlunos() {
		if (alunos.isEmpty()) {
			return 0.0;
		}
		double soma = 0;
		for (Aluno aluno : alunos) {
			soma += aluno.getNotaFinal();
		}
		return soma / alunos.size();
	}

	@Override
	public String toString() {
		return "Treinamento #" + id + " - " + linguagemEnsinada + " (Instrutor: " + nomeInstrutor
				+ ", Carga horária: " + cargaHoraria + "h, Alunos: " + alunos.size() + ")";
	}
}
