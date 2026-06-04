package br.edu.fatecpg.abstracao.model;

public class Piloto {
  
    public String nome;
    public int idade;
    public String licenca_voo;
    public int horas_de_voo;
    public String companhia_aerea;
    public String aeronave_atual;
    
    public void decolar() {
       System.out.println("Decolando...");
       System.out.println("Decolagem concluída com sucesso.");
    }
    public void aterrissar() {
       System.out.println("Aterrissando...");
       System.out.println("Aterrissagem concluída com sucesso.");
    }
    public void comunicarTorre() {
       System.out.println("Iniciando comunicação com torre...");
       System.out.println("Comunicação concluída com sucesso.");
    }
    public void ajustarRota() {
       System.out.println("Ajustando rota...");
       System.out.println("Rota ajustada com sucesso.");
    }
}
