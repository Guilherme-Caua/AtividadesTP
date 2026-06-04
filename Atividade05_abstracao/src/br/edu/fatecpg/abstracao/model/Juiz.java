package br.edu.fatecpg.abstracao.model;

public class Juiz {
    
    public String nome;
    public int idade;
    public String comarca;
    public int anos_de_magistratura;
    public String status_tribunal;
    
    public void proferirSentenca(){
        System.out.println("Proferindo sentença...");
        System.out.println("Sentença proferida com sucesso.");
    }
    public void assinarDespacho() {
        System.out.println("Assinando despacho...");
        System.out.println("Despacho assinado com sucesso.");

    }
    public void presidirJulgamento() {
        System.out.println("Presidindo julgamento...");
        System.out.println("Julgamento presidido com sucesso.");
    }
    public void analisarProvas() {
        System.out.println("Analisando provas...");
        System.out.println("Provas avaliadas com sucesso.");
    }
}