package br.edu.fatecpg.abstracao.model;

public class Arquiteto {
	public String nome;
	public String rnp;
	public String cau;
	public String especialidade;
	public String[] historico_projetos;
    
    public void planejarProjetos() {
        System.out.println("Planejando novo projeto.");
        System.out.println("Projeto planejado com sucesso!");
    }
    public void desenharPlanos() {
        System.out.println("Desenhando plano de projeto...");
        System.out.println("Plano desenhado com suceso!");
    }
    public void definirMateriais() {
        System.out.println("Definindo materiais para projeto...");
        System.out.println("Materiais definidos com sucesso!");
    }
}
