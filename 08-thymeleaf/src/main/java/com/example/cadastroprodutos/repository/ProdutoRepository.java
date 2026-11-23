package com.example.cadastroprodutos.repository;

import com.example.cadastroprodutos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Exercício 18: o Spring Data JPA gera a implementação sozinho.
 * Os métodos abaixo são consultas derivadas do próprio nome.
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeContainingIgnoreCase(String nome);

    List<Produto> findByCategoria(String categoria);

    List<Produto> findByNomeContainingIgnoreCaseAndCategoria(String nome, String categoria);
}
