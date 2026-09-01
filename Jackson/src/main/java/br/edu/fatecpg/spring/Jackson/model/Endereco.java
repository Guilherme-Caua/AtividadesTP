package br.edu.fatecpg.spring.Jackson.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Endereco(
        String cep,
        @JsonAlias("loradouro") String rua,
        String bairro,
        @JsonAlias("localidade") String cidade,
        String uf
) {}
