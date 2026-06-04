package br.edu.fatecpg.abstracao.model;

public class Cantor {
    public String nome;
    public String[] generos;
    public String discografia;
    public String[] instrumentos;
    public boolean em_banda;

    public void gravar() {
        System.out.println("Gravando...");
        System.out.println("Gravação concluida com sucesso.");
    }
    public void fazerShow() {
        System.out.println("Realizando show...");
        System.out.println("Show concluido com sucesso.");
    }
    public void darAutografo() {
        System.out.println("Escrevendo autógrafo...");
        System.out.println("Autógrafo escrito com sucesso.");
    }
}
