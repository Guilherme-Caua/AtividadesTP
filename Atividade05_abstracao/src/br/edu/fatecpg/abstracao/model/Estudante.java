package br.edu.fatecpg.abstracao.model;

public class Estudante {
    
    public String nome;
    public String instituicao_ensino;
    public String turma;
    public String materia_preferida;
    public String data_nascimento; 
   
    public void assistirAula(){
        System.out.println("Assistindo aula...");
        System.out.println("Aula assistida com sucesso.");
    }
    public void escrever(String anotacao){

        System.out.println("Escrevendo '"+anotacao+"'...");
        System.out.println("'"+anotacao+"' escrito com sucesso");
    }
    public void conversar(){
        System.out.println("Conversando...");
        System.out.println("Conversa concluida com sucesso.");
    }
    public void estudarLivro(){
        System.out.println("Lendo livro...");
        System.out.println("Livro lido com sucesso.");
    }
}
