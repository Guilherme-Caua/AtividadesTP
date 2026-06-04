package br.edu.fatecpg.abstracao.model;

public class Programador {
    
    public String nome;
    public String area_atuacao;
    public String especialidades;
    public String paradigma_favorito;
    public String cargo;
    
    public void escreverCodigo() {
       System.out.println("Escrevendo código...");
       System.out.println("Código escrito com sucesso.");
    }
    public void desenharFluxograma() {
       System.out.println("Desenhando fluxograma...");
       System.out.println("Fluxograma desenhado com sucesso.");
    }
    public void debugarCodigo() {
       System.out.println("Iniciando sessão de debug...");
       System.out.println("Código debugado com sucesso!");
    }
    public void completarTask() {
       System.out.println("Iniciando task...");
       this.escreverCodigo();
       this.debugarCodigo();
       System.out.println("Task concluída com sucesso");
    }
}
