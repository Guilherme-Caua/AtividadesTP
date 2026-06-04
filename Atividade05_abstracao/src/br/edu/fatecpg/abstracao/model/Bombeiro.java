package br.edu.fatecpg.abstracao.model;

public class Bombeiro {
    
    public String nome;
    public int idade;
    public String especialidade;
    public int anos_de_servico;
    public String quartel_bombeiros;
    
    public void apagarIncendio() {
        System.out.println("Apagando incendio...");
        System.out.println("Incendio apagado com sucesso.");
    }
    public void resgatar_vitima() {
        System.out.println("Resgatando vitima...");
        System.out.println("Vitima resgatada com sucesso.");
    }
    public void dirigirCaminhao() {
        System.out.println("Dirigindo caminhão...");
            System.out.println("Caminhão dirigido com sucesso.");
    }
}
