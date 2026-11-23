package com.example.cadastroprodutos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    // BigDecimal em vez de double: evita erros de arredondamento com dinheiro
    @NotNull(message = "Informe o preço.")
    @PositiveOrZero(message = "O preço não pode ser negativo.")
    private BigDecimal preco;

    @NotBlank(message = "Escolha uma categoria.")
    private String categoria;

    // Exercício 1: novos atributos
    private String descricao;

    @NotNull(message = "Informe o estoque.")
    @PositiveOrZero(message = "O estoque não pode ser negativo.")
    private Integer estoque = 0;

    // O Spring/JPA precisa do construtor vazio
    public Produto() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Integer getEstoque() { return estoque; }
    public void setEstoque(Integer estoque) { this.estoque = estoque; }
}
