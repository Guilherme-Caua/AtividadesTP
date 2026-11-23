package com.example.cadastroprodutos.service;

import com.example.cadastroprodutos.model.Produto;
import com.example.cadastroprodutos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Exercício 16: a lógica de armazenamento saiu do Controller e veio para o Service.
 */
@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void salvar(Produto produto) {
        repository.save(produto);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    /** Exercício 17: busca por nome e/ou categoria. Parâmetro vazio = sem filtro. */
    public List<Produto> buscar(String nome, String categoria) {
        boolean temNome = nome != null && !nome.isBlank();
        boolean temCategoria = categoria != null && !categoria.isBlank();

        if (temNome && temCategoria) {
            return repository.findByNomeContainingIgnoreCaseAndCategoria(nome.trim(), categoria);
        }
        if (temNome) {
            return repository.findByNomeContainingIgnoreCase(nome.trim());
        }
        if (temCategoria) {
            return repository.findByCategoria(categoria);
        }
        return repository.findAll();
    }
}
