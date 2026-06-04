package br.edu.fatecpg.abstracao.model;

public class Policial {
    
    public String nome;
    public int idade;
    public String patente;
    public String arma;
    public int anos_de_servico;
    
    public void prenderSuspeito() {
    System.out.println("Realizando prisão...");
    System.out.println("Prisão realizada com sucesso.");
    }
    public void patrulhar() {
    System.out.println("Patrulhando...");
    System.out.println("Patrulha realizada com sucesso.");
    }
    public void registrarOcorrencia() {
    System.out.println("Registrando ocorrência...");
    System.out.println("Ocorrência registrada com sucesso.");
    }
}