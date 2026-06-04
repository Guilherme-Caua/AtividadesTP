package br.edu.fatecpg.abstracao.model;

public class Pintor {
    
    public String nome;
    public String cpf;
    public String especialidade;
    public String[] projetos;
    public String formacao;
    
    public void desenhar() {
       System.out.println("Desenhando...");
       System.out.println("Desenho concluído com sucesso.");
    }
    public void pintar() {
       System.out.println("Pintando...");
       System.out.println("Pintura concluída com sucesso.");
    }
    public void publicarArte() {
       System.out.println("Publicando arte...");
       System.out.println("Arte publicada com sucesso.");
    }
}