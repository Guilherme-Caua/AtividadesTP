package com.example.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Um personagem retornado pela API. Campos que não declaramos são ignorados.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosPersonagem(int id,
                              String name,
                              String status,
                              String species,
                              String gender,
                              Local origin,
                              Local location) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Local(String name) {
    }

    @Override
    public String toString() {
        return String.format("#%d %s | %s | %s | %s | origem: %s",
                id, name, status, species, gender, origin.name());
    }
}
