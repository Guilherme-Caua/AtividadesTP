package br.edu.fatecpg.polimorfismo.model;

public class Produto {

    private String nome;
    private double preco;
    private int estoque;

    public Produto(String nome) {
        this.nome = nome;
        this.preco = 0.0;
        this.estoque = 0;
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = 0;
    }

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + " | Preco: R$ " + preco + " | Estoque: " + estoque;
    }
}
