package com.example.consulta;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Converte JSON em objetos de qualquer tipo. O ObjectMapper fica aqui, e não
 * na classe principal, e o mesmo método serve para qualquer classe de dados.
 */
public class ConverteDados {

    private final ObjectMapper mapper = new ObjectMapper();

    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter o JSON: " + e.getOriginalMessage(), e);
        }
    }
}
