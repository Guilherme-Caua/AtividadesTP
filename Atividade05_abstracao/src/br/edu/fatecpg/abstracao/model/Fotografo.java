package br.edu.fatecpg.abstracao.model;

public class Fotografo {
    
    public String nome;
    public int idade;
    public String especialidade;
    public String[] equipamentos;
    public String localizacao;
    public String contato;
    
    public void tirarFotos(){
        System.out.println("Tirando fotos...");
        System.out.println("Fotos tiradas com sucesso.");
    }
    public void editarFotos(){
        System.out.println("Editando fotos...");
        System.out.println("Fotos editadas com sucesso.");
    }
    public void agendarEnsaios(){
        System.out.println("Agendando ensaios...");
        System.out.println("Ensaios agendados com sucesso.");
    }
    public void calcularOrcamento(){
        System.out.println("Calculando orçamento...");
        System.out.println("Orçamento calculado com sucesso.");
    }
    public void enviarFotosClientes(){
        System.out.println("Enviando fotos para clientes...");
        System.out.println("Fotos enviadas com sucesso.");
    }
}