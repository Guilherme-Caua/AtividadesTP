package br.edu.fatecpg.abstracao.model;

public class Atleta {
    public String nome;
    public int idade;
    public String esporte;
    public String clube;
    public String categoria;
    public double altura;
    public double peso;
    public double salario;
    
    public void treinar() {
        System.out.println("Realizando treino...");
        System.out.println("Treino realizado com sucesso!");
    }
    public void competir() {
        System.out.println("Realizando competição...");
        System.out.println("Competição realizada com sucesso!");
    }
    public void descansar() {
        System.out.println("Descansando...");
        System.out.println("Descanso realizado com sucesso!");
    }
    public void cuidarSaude() {
        System.out.println("Realizando consulta...");
        System.out.println("Saúde tratada com sucesso!");
    }
    public void cumprirContrato() {
        System.out.println("Cumprindo com contrato estabelecido...");
        System.out.println("Contrato cumprido com sucesso!");
    }
}
