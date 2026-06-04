package br.edu.fatecpg.abstracao.model;

public class Motorista {
   
    public String nome;
    public int idade;
    public String tipo_carteira;
    public String veiculo;
    public int anos_experiencia;
    
    public void dirigir() {
       System.out.println("Dirigindo...");
       System.out.println("Direção concluída com sucesso.");
    }
    public void estacionar() {
       System.out.println("Estacionando...");
       System.out.println("Estacionado com sucesso.");

    }
    public void abastecer(int qtde_litros) {
       System.out.println("Abastecendo...");
       System.out.println("Abastecido "+qtde_litros+" litros com sucesso.");
    }
}
