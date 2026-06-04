package br.edu.fatecpg.abstracao.model;

public class Professor {
   
    public String nome;
    public double salario;
    public String especialidade;
    public String situacao_trabalho;
    public int tempo_de_carreira;
    
    public void prepararAula() {
       System.out.println("Preparando aula...");
       System.out.println("Aula preparada com sucesso.");
    }
    public void prepararProva() {
       System.out.println("Preparando prova...");
       System.out.println("Prova preparada com sucesso.");
    }
    public void aplicarProva() {
       System.out.println("Aplicando prova...");
       System.out.println("Prova aplicada com sucesso.");
    }
    public void darAula() {
       System.out.println("Aplicando aula para alunos...");
       System.out.println("Aula aplicada com sucesso.");
    }
    public void estudar() {
       System.out.println("Estudando conteúdo da aula...");
       System.out.println("Estudo concluído com sucesso.");
    }
}
