package br.edu.fatecpg.abstracao.model;

public class Engenheiro {
   
    public String nome;
    public String especialidade;
    public String rnp;
    public String[] projetos_previos;
    public String nivel_de_graduacao;
    
    public void planejarProjeto() {
        System.out.println("Planejando projeto...");
        System.out.println("Projeto planejado com sucesso.");
    }
    public void fiscalizarProjeto() {
        System.out.println("Fiscalizando projeto...");
        System.out.println("Projeto fiscalizado com sucesso.");
    }
    public void emitirLaudoTecnico() {
        System.out.println("Emitindo laudo técnico...");
        System.out.println("Laudo emitido com sucesso.");
    }
}