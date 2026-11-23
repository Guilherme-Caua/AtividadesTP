package com.example.springweb.controller;

import com.example.springweb.model.Livro;
import com.example.springweb.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    // 1) Listar todos
    @GetMapping
    public List<Livro> listar() {
        return repository.findAll();
    }

    // 2) Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3) Criar
    @PostMapping
    public ResponseEntity<Livro> criar(@Valid @RequestBody Livro livro) {
        livro.setId(null); // garante que será um novo registro
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(livro));
    }

    // 4) Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @Valid @RequestBody Livro dados) {
        return repository.findById(id)
                .map(livro -> {
                    livro.setTitulo(dados.getTitulo());
                    livro.setAutor(dados.getAutor());
                    livro.setIsbn(dados.getIsbn());
                    livro.setAnoPublicacao(dados.getAnoPublicacao());
                    return ResponseEntity.ok(repository.save(livro));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5) Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
