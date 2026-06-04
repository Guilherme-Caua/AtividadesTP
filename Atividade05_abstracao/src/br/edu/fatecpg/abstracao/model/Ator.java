package br.edu.fatecpg.abstracao.model;

public class Ator {

	    public String nome;
	    public String drt;
	    public int idade;
	    public String[] idiomas_fluentes;
	    public String[] papeis_previos;
	    
	    public void falar(String fala) {
	        System.out.println("[" + this.nome + "] " + fala);
	    }
	    public void chorar() {
	        System.out.println("buaaaaaaaa");
	    }
	    public void trocarFigurino() {
	        System.out.println("Trocando de figurino...");
	        System.out.println("Figurido trocado com sucesso.");
	    }
	}