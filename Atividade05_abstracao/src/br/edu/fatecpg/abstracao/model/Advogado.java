package br.edu.fatecpg.abstracao.model;

public class Advogado {
	public String nome;
	public int idade;
	public String numero_oab;
	public String especialidade;
	public String escritorio;
	public String[] casos_ativos;
	
	public void peticionar() {
		System.out.println("Peticionando...");
		System.out.println("Petição realizada com êxito.");
	}
	public void defenderCliente() {
		System.out.println("Realizando defesa...");
		System.out.println("Defesa realizada com êxito.");
	}
	public void analisarProcesso() {
		System.out.println("Analisando processo...");
		System.out.println("Processo analisado com êxito.");
	}
	public void participarAudiencia() {
		System.out.println("Participando de audiencia...");
		System.out.println("Audiencia participada com êxito!");
	}
}
